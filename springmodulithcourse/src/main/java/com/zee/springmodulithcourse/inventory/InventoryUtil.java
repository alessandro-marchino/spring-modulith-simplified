package com.zee.springmodulithcourse.inventory;

import com.zee.springmodulithcourse.inventory.exposed.InventoryDto;

import lombok.experimental.UtilityClass;

@UtilityClass
class InventoryUtil {

	public static InventoryDto mapInventoryDto(Inventory inventory) {
		return new InventoryDto(inventory.getId(), inventory.getName(), inventory.getDescription(), inventory.getPrice());
	}
}
