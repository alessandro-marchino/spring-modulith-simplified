package com.zee.springmodulithcourse.payment;

import java.util.Optional;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import com.zee.springmodulithcourse.order.dto.CompleteOrderDto;
import com.zee.springmodulithcourse.order.dto.OrderPaymentDto;
import com.zee.springmodulithcourse.payment.type.PaymentStatus;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class PaymentEventService {

	private final PaymentRepository paymentRepository;

	@ApplicationModuleListener
	void on(OrderPaymentDto orderPaymentDto) {
		log.info("Order payment received in listener: {}", orderPaymentDto);
		
		Payment payment = new Payment();
		payment.setOrderId(orderPaymentDto.orderId());
		payment.setAmount(orderPaymentDto.amount());
		paymentRepository.save(payment);
	}

	@ApplicationModuleListener
	void completeOrder(CompleteOrderDto completeOrderDto) {
		log.info("Complete order received in listener: {}", completeOrderDto);
		
		Optional<Payment> optionalPayment = paymentRepository.getByOrderId(completeOrderDto.orderIdentifier());
		if(optionalPayment.isPresent()) {
			Payment payment = optionalPayment.get();
			payment.setStatus(PaymentStatus.COMPLETE);
			paymentRepository.save(payment);
		}
	}
}
