package com.zee.springmodulithcourse.order.dto;

import org.jmolecules.event.types.DomainEvent;

import com.zee.springmodulithcourse.eventaction.action.Action;
import com.zee.springmodulithcourse.eventaction.action.CustomEventMarker;

@CustomEventMarker(Action.PAYMENT)
public record OrderPaymentDto(String orderId, long amount) implements DomainEvent {

}
