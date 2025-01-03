package com.zee.springmodulithcourse.order;

import java.time.Instant;

import com.zee.springmodulithcourse.order.type.Status;
import com.zee.springmodulithcourse.order.typeconverter.StatusConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	@Column(nullable = false, unique = true)
	private String orderIdentifier;
	private String customerName;
	private String customerEmail;
	private Instant orderDate = Instant.now();
	@Convert(converter = StatusConverter.class)
	private Status status = Status.OPEN;

}
