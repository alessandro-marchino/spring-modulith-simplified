package com.zee.springmodulithcourse.eventaction.action;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Action {

	COMPLETE_PAYMENT("C"),
	PAYMENT("P"),
	EMAIL("E");

	private String code;
	public static Action getActionByName(String name) {
		return Arrays.stream(Action.values())
				.filter(action -> action.name().equals(name))
				.findFirst()
				.orElse(null);
	}
}
