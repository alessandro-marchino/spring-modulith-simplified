package com.zee.springmodulithcourse.inventory;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zee.springmodulithcourse.inventory.exposed.InventoryDto;
import com.zee.springmodulithcourse.inventory.exposed.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class InventoryServiceImpl implements InventoryService {
	private final InventoryRepository inventoryRepository;

	@Override
	public InventoryDto fetchInventoryByName(String name) {
		return inventoryRepository.getInventoryByName(name)
				.map(InventoryUtil::mapInventoryDto)
				.orElseThrow(() -> new RuntimeException("Could not find inventory by name: " + name));
	}

	@Override
	public List<InventoryDto> fetchAllInName(List<String> inventoryNames) {
		return inventoryRepository
				.getInventoryByNameIn(inventoryNames)
				.stream()
				.map(InventoryUtil::mapInventoryDto)
				.toList();
	}

}
