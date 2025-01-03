package com.zee.springmodulithcourse.order;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
	Optional<Order> getOrderByOrderIdentifier(String orderIdentifier);
}
