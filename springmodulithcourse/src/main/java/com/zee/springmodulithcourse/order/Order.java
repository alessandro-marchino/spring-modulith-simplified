package com.zee.springmodulithcourse.order;

import java.time.Instant;

import com.zee.springmodulithcourse.order.type.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String orderIdentifier;
	private String customerName;
	private String customerEmail;
	@Temporal(TemporalType.TIMESTAMP)
	private Instant orderDate = Instant.now();
	private Status status = Status.OPEN;

}
