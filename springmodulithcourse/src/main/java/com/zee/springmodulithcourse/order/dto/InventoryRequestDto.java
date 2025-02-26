package com.zee.springmodulithcourse.order.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record InventoryRequestDto(
		@NotBlank(message = "inventoryName is required")
		String inventoryName,
		@Min(value = 1L, message = "the value must be greater than 0")
		int quantity) {

}
