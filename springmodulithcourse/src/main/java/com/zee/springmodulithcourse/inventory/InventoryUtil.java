package com.zee.springmodulithcourse.inventory;

import com.zee.springmodulithcourse.inventory.exposed.InventoryDto;

import lombok.experimental.UtilityClass;

@UtilityClass
public class InventoryUtil {

	public static InventoryDto mapInventoryDto(Inventory inventory) {
		return InventoryDto.builder()
			.id(inventory.getId())
			.name(inventory.getName())
			.description(inventory.getDescription())
			.price(inventory.getPrice())
			.build();
	}
}
