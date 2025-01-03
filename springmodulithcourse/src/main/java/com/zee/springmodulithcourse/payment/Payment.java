package com.zee.springmodulithcourse.payment;

import java.time.Instant;

import com.zee.springmodulithcourse.payment.type.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String orderId;
	private long amount;
	@Temporal(TemporalType.TIMESTAMP)
	private Instant paymentDate = Instant.now();
	private PaymentStatus status = PaymentStatus.INCOMPLETE;
	
}
