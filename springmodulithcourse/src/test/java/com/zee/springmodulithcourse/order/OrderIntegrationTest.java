package com.zee.springmodulithcourse.order;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.ApplicationModuleTest.BootstrapMode;

import com.zee.springmodulithcourse.order.dto.InventoryRequestDto;
import com.zee.springmodulithcourse.order.dto.OrderDto;
import com.zee.springmodulithcourse.order.dto.OrderResponseDto;

@ApplicationModuleTest(mode = BootstrapMode.DIRECT_DEPENDENCIES)
class OrderIntegrationTest {

	@Autowired OrderService orderService;

	@Test
	void verifyModule() {
		// Nothing
	}

	@Test
	void createOrder() {
		OrderDto orderDto = new OrderDto("Test Man", "test@test.com", List.of(
			new InventoryRequestDto("ruler", 3),
			new InventoryRequestDto("pencil", 4)
		));
		OrderResponseDto order = orderService.createOrder(orderDto);
		Assertions.assertThat(order.message()).isEqualTo("Order currently processed");
		Assertions.assertThat(order.statusCode()).isEqualTo(100);
	}

}
