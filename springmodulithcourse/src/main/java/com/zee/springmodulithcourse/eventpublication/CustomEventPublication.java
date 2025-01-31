package com.zee.springmodulithcourse.eventpublication;

import java.sql.Timestamp;
import java.util.UUID;

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
@Table(name = "event_publication")
public class CustomEventPublication {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String listenerId;
	private String eventType;
	private String serializedEvent;
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp completionDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp publicationDate;
}
