package com.zee.springmodulithcourse.payment;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import com.zee.springmodulithcourse.order.dto.OrderPaymentDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class PaymentEventService {

	private final PaymentRepository paymentRepository;

	@ApplicationModuleListener
	void on(OrderPaymentDto orderPaymentDto) {
		throw new RuntimeException("this failed");
//		log.info("Order payment received in listener: {}", orderPaymentDto);
	}
}
