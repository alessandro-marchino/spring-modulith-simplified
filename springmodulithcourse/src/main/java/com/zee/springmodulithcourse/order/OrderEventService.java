package com.zee.springmodulithcourse.order;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.zee.springmodulithcourse.order.dto.OrderPaymentDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventService {

	private final ApplicationEventPublisher eventPublisher;

	@Transactional
	public void completeOrder(OrderPaymentDto orderPaymentDto) {
		log.info("Completing order payment with details: {}", orderPaymentDto);
		eventPublisher.publishEvent(orderPaymentDto);
	}
}
