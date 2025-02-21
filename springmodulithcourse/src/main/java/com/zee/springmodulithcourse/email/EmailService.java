package com.zee.springmodulithcourse.email;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import com.zee.springmodulithcourse.order.dto.EmailDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailService {

	@ApplicationModuleListener
	void sendEmail(final EmailDto emailDto) {
		log.info("Email properties received");
		if(!emailDto.orderComplete()) {
			String body = "Dear " + emailDto.customerName() + ".\nAn order was initialized with id: "
					+ emailDto.orderIdentifier() + " and total sum of " + (emailDto.totalAmount() / 100.0);
			log.info("Initial email order details: {}", body);
		} else {
			String body = "Dear " + emailDto.customerName() + ".\nYour order with id "
					+ emailDto.orderIdentifier() + " and total sum of " + (emailDto.totalAmount() / 100.0)
					+ " was compled successfully";
			log.info("Email completion details: {}", body);
		}
		log.info("Email sent to {}",emailDto.email());
		
	}
}
