package com.zee.springmodulithcourse.payment.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PaymentStatus {

	INCOMPLETE("I"),
	COMPLETE("C"),
	FAILED("F");

	private final String code;
}
