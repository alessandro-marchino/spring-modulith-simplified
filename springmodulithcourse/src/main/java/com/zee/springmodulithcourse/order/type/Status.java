package com.zee.springmodulithcourse.order.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
	OPEN("O"),
	COMPLETED("C");

	private final String code;
}
