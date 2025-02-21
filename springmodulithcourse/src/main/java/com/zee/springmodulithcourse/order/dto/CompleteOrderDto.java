package com.zee.springmodulithcourse.order.dto;

import org.jmolecules.event.types.DomainEvent;

import com.zee.springmodulithcourse.eventaction.action.Action;
import com.zee.springmodulithcourse.eventaction.action.CustomEventMarker;

@CustomEventMarker(Action.COMPLETE_PAYMENT)
public record CompleteOrderDto(String orderIdentifier, boolean paymentComplete) implements DomainEvent {

}
