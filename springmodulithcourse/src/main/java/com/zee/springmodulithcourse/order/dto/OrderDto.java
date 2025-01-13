package com.zee.springmodulithcourse.order.dto;

import java.util.List;

public record OrderDto(String customerName, String customerEmail, List<InventoryRequestDto> inventories) {

}
