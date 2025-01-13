package com.zee.springmodulithcourse.order;

import org.springframework.stereotype.Service;

import com.zee.springmodulithcourse.inventory.exposed.InventoryService;
import com.zee.springmodulithcourse.order.dto.OrderDto;
import com.zee.springmodulithcourse.order.dto.OrderResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	@SuppressWarnings("unused")
	private final InventoryService inventoryService;

	public OrderResponseDto createOrder(OrderDto order) {
		// TODO: get the inventories by names
		// build and persist the order
		return null;
	}
}
