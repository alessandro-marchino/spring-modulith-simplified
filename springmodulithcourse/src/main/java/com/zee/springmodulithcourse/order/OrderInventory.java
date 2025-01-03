package com.zee.springmodulithcourse.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(indexes = {
	@Index(name = "ord_idx", columnList = "order_id"),
	@Index(name = "inv_idx", columnList = "inventory_id")
})
public class OrderInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private long orderId;
	private long inventoryId;
	private int quantity;
	private long totalQuantityPrice;
}
