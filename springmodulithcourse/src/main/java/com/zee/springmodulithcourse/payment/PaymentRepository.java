package com.zee.springmodulithcourse.payment;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PaymentRepository extends CrudRepository<Payment, Long> {
	Optional<Payment> getByOrderId(String orderId);

}
