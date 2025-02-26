package com.zee.springmodulithcourse.eventaction.typeconverter;

import java.util.Arrays;

import com.zee.springmodulithcourse.eventaction.action.Action;
import com.zee.springmodulithcourse.exception.ModulithException;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ActionTypeConverter implements AttributeConverter<Action, String> {

	@Override
	public String convertToDatabaseColumn(Action action) {
		if(action == null) {
			throw new ModulithException("Action cannot be null");
		}
		return action.getCode();
	}

	@Override
	public Action convertToEntityAttribute(String code) {
		if(code == null) {
			throw new ModulithException("Code cannot be null");
		}
		return Arrays.stream(Action.values())
				.filter(action -> action.getCode().equals(code))
				.findFirst()
				.orElseThrow(() -> new ModulithException("Action not found"));
	}

}
