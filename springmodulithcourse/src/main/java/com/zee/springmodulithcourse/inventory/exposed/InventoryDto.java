package com.zee.springmodulithcourse.inventory.exposed;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryDto {

	private Long id;
	private String name;
	private String description;
	private long price;
}
