package com.zee.springmodulithcourse.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.springmodulithcourse.order.dto.CompleteOrderDto;
import com.zee.springmodulithcourse.order.dto.CompleteOrderResponseDto;
import com.zee.springmodulithcourse.order.dto.OrderDto;
import com.zee.springmodulithcourse.order.dto.OrderResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderDto orderDto) {
		return ResponseEntity.ok(orderService.createOrder(orderDto));
	}

	@PostMapping("/complete")
	public ResponseEntity<CompleteOrderResponseDto> createOrder(@RequestBody CompleteOrderDto completeOrderDto) {
		return ResponseEntity.ok(orderService.completePayment(completeOrderDto));
	}
}
