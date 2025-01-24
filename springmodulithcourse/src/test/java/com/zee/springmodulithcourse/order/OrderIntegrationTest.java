package com.zee.springmodulithcourse.order;

import java.util.List;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;
import org.springframework.modulith.test.ApplicationModuleTest.BootstrapMode;

import com.zee.springmodulithcourse.order.dto.InventoryRequestDto;
import com.zee.springmodulithcourse.order.dto.OrderDto;
import com.zee.springmodulithcourse.order.dto.OrderPaymentDto;
import com.zee.springmodulithcourse.order.dto.OrderResponseDto;

import lombok.extern.slf4j.Slf4j;

@ApplicationModuleTest(mode = BootstrapMode.DIRECT_DEPENDENCIES)
@Slf4j
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
	
	@Test
	void publishOrderPaymentEvent(Scenario scenario) {
		scenario.publish(new OrderPaymentDto(UUID.randomUUID().toString(), 50000L))
			.andWaitForEventOfType(OrderPaymentDto.class)
			.matching(event -> event.amount() == 50000L)
			.toArriveAndVerify(ev -> log.info("Amount: {}", ev.amount()));
	}

}
