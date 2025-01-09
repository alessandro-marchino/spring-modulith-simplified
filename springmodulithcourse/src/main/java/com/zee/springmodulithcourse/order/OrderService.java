package com.zee.springmodulithcourse.order;

import org.springframework.stereotype.Service;

import com.zee.springmodulithcourse.inventory.exposed.InventoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final InventoryService inventoryService;
}
