package com.zee.springmodulithcourse.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.zee.springmodulithcourse.exception.ModulithException;
import com.zee.springmodulithcourse.inventory.exposed.InventoryDto;
import com.zee.springmodulithcourse.inventory.exposed.InventoryService;
import com.zee.springmodulithcourse.order.dto.CompleteOrderDto;
import com.zee.springmodulithcourse.order.dto.CompleteOrderResponseDto;
import com.zee.springmodulithcourse.order.dto.EmailDto;
import com.zee.springmodulithcourse.order.dto.InventoryRequestDto;
import com.zee.springmodulithcourse.order.dto.OrderDto;
import com.zee.springmodulithcourse.order.dto.OrderPaymentDto;
import com.zee.springmodulithcourse.order.dto.OrderResponseDto;
import com.zee.springmodulithcourse.order.type.Status;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

	private final InventoryService inventoryService;
	private final OrderRepository orderRepository;
	private final OrderInventoryRepository orderInventoryRepository;
	
	private final OrderEventService orderEventService;

	public OrderResponseDto createOrder(OrderDto orderDto) {
		// Get inventories by name
		List<String> inventoryNames = orderDto.inventories().stream()
				.map(InventoryRequestDto::inventoryName)
				.toList();
		List<InventoryDto> inventories = inventoryService.fetchAllInName(inventoryNames);
		// Persist the Order
		Order order = buildAndPersistOrder(orderDto);
		log.info("Order created: {}", order);
		
		// build and persist the OrderInventory
		AtomicLong amount = new AtomicLong();
		buildAndPersistOrderInventory(order, inventories, orderDto.inventories(), amount);
		
		OrderPaymentDto orderPaymentDto = new OrderPaymentDto(order.getOrderIdentifier(), amount.get());
		EmailDto emailDto = new EmailDto(orderDto.customerEmail(), orderDto.customerName(), order.getOrderIdentifier(), orderPaymentDto.amount(), false);
		
		orderEventService.completeOrder(orderPaymentDto, emailDto);
		return new OrderResponseDto("Order currently processed", 100);
	}

	public CompleteOrderResponseDto completePayment(CompleteOrderDto completeOrderDto) {
		Optional<Order> optionalOrder = orderRepository.getOrderByOrderIdentifier(completeOrderDto.orderIdentifier());
		if(optionalOrder.isEmpty()) {
			throw new ModulithException("Order not found");
		}
		Order order = optionalOrder.get();
		long amount = orderInventoryRepository.orderIdAmount(order.getId());
		EmailDto emailDto = new EmailDto(order.getCustomerEmail(), order.getCustomerName(), order.getOrderIdentifier(), amount, true);
		orderEventService.completePayment(completeOrderDto, emailDto);
		return new CompleteOrderResponseDto(true);
	}

	private Order buildAndPersistOrder(OrderDto orderDto) {
		Order order = new Order();
		order.setOrderIdentifier(UUID.randomUUID().toString());
		order.setCustomerName(orderDto.customerName());
		order.setCustomerEmail(orderDto.customerEmail());
		order.setStatus(Status.COMPLETED);
		
		return orderRepository.save(order);
	}
	
	private void buildAndPersistOrderInventory(Order order, List<InventoryDto> inventories, List<InventoryRequestDto> inventoryRequestDtoList, AtomicLong amount) {
		List<OrderInventory> orderInventories = new ArrayList<>(inventories.size());
		inventories.forEach(inventoryDto -> {
			OrderInventory orderInventory = new OrderInventory();
			InventoryRequestDto inventoryRequestDto = getInventoryRequestDtoByName(inventoryDto.name(), inventoryRequestDtoList);
			orderInventory.setOrderId(order.getId());
			orderInventory.setInventoryId(inventoryDto.id());
			orderInventory.setQuantity(inventoryRequestDto.quantity());
			long totalPrice = inventoryDto.price() * inventoryRequestDto.quantity();
			orderInventory.setTotalQuantityPrice(totalPrice);
			amount.addAndGet(totalPrice);
			
			orderInventories.add(orderInventory);
		});
		orderInventoryRepository.saveAll(orderInventories);
	}
	private static InventoryRequestDto getInventoryRequestDtoByName(String inventoryName, List<InventoryRequestDto> inventoryRequestDtoList) {
		return inventoryRequestDtoList.stream()
				.filter(inv -> inv.inventoryName().equals(inventoryName))
				.findFirst()
				.orElse(null);
	}

}
