package com.zee.springmodulithcourse.inventory.exposed;

import java.util.List;

public interface InventoryService {

	InventoryDto fetchInventoryByName(String name);
	List<InventoryDto> fetchAllInName(List<String> inventoryNames);
}
