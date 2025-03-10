package com.zee.springmodulithcourse.order;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.zee.springmodulithcourse.order.dto.CompleteOrderDto;
import com.zee.springmodulithcourse.order.dto.EmailDto;
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
	public void completeOrder(OrderPaymentDto orderPaymentDto, EmailDto emailDto) {
		log.info("Completing order payment with details: {}", orderPaymentDto);
		eventPublisher.publishEvent(orderPaymentDto);
		
		log.info("Sending email for order {}", emailDto);
		eventPublisher.publishEvent(emailDto);
	}

	@Transactional
	public void completePayment(CompleteOrderDto completeOrderDto, EmailDto emailDto) {
		log.info("Attempting to complete payment {}", completeOrderDto);
		eventPublisher.publishEvent(completeOrderDto);
		
		log.info("Completed payment email {}", emailDto);
		eventPublisher.publishEvent(emailDto);
	}
}
