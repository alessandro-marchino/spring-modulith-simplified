package com.zee.springmodulithcourse.order.typeconverter;

import java.util.Arrays;

import com.zee.springmodulithcourse.order.type.Status;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StatusConverter implements AttributeConverter<Status, String> {

	@Override
	public String convertToDatabaseColumn(Status attribute) {
		return attribute != null ? attribute.getCode() : null;
	}

	@Override
	public Status convertToEntityAttribute(String dbData) {
		return Arrays.stream(Status.values())
				.filter(status -> status.getCode().equalsIgnoreCase(dbData))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No status corresponding to value " + dbData));
	}

}
