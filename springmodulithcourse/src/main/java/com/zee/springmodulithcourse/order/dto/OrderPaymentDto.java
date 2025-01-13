package com.zee.springmodulithcourse.order.dto;

import org.jmolecules.event.types.DomainEvent;

public record OrderPaymentDto(String orderId, long amount) implements DomainEvent {

}
