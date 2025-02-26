package com.zee.springmodulithcourse.order.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record OrderDto(
		@NotBlank(message = "customerName is required")
		String customerName,
		@NotBlank(message = "customerEmail is required")
		String customerEmail,
		@Valid
		@NotEmpty(message = "inventories cannot be empty")
		List<InventoryRequestDto> inventories) {

}
