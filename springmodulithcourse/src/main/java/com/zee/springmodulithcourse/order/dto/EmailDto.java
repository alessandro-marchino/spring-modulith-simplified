package com.zee.springmodulithcourse.order.dto;

import org.jmolecules.event.types.DomainEvent;

import com.zee.springmodulithcourse.eventaction.action.Action;
import com.zee.springmodulithcourse.eventaction.action.CustomEventMarker;

@CustomEventMarker(Action.EMAIL)
public record EmailDto(String email, String customerName, String orderIdentifier, long totalAmount, boolean orderComplete) implements DomainEvent{

}
