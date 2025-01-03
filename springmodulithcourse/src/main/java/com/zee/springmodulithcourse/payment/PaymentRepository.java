package com.zee.springmodulithcourse.payment;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
	Optional<Payment> getByOrderId(String orderId);

}
