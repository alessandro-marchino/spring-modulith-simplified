package com.zee.springmodulithcourse.eventaction.action;

import java.util.Arrays;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ActionTypeConverter implements AttributeConverter<Action, String> {

	@Override
	public String convertToDatabaseColumn(Action action) {
		if(action == null) {
			throw new RuntimeException("Action cannot be null");
		}
		return action.getCode();
	}

	@Override
	public Action convertToEntityAttribute(String code) {
		if(code == null) {
			throw new RuntimeException("Code cannot be null");
		}
		return Arrays.stream(Action.values())
				.filter(action -> action.getCode().equals(code))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Action not found"));
	}

}
