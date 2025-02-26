package com.zee.springmodulithcourse.order.dto;

import org.jmolecules.event.types.DomainEvent;

import com.zee.springmodulithcourse.eventaction.action.Action;
import com.zee.springmodulithcourse.eventaction.action.CustomEventMarker;

import jakarta.validation.constraints.NotBlank;

@CustomEventMarker(Action.COMPLETE_PAYMENT)
public record CompleteOrderDto(
		@NotBlank(message = "orderIdentifier is required")
		String orderIdentifier,
		boolean paymentComplete) implements DomainEvent {

}
