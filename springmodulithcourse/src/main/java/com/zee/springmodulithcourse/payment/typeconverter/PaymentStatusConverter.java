package com.zee.springmodulithcourse.payment.typeconverter;

import java.util.Arrays;

import com.zee.springmodulithcourse.exception.ModulithException;
import com.zee.springmodulithcourse.payment.type.PaymentStatus;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, String> {

	@Override
	public String convertToDatabaseColumn(PaymentStatus attribute) {
		if(attribute == null) {
			throw new ModulithException("Status cannot be null");
		}
		return attribute.getCode();
	}

	@Override
	public PaymentStatus convertToEntityAttribute(String dbData) {
		if(dbData == null) {
			throw new ModulithException("Status cannot be null");
		}
		return Arrays.stream(PaymentStatus.values())
				.filter(status -> status.getCode().equalsIgnoreCase(dbData))
				.findFirst()
				.orElseThrow(() -> new ModulithException("No status corresponding to value " + dbData));
	}

}
