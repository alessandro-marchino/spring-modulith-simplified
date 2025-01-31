package com.zee.springmodulithcourse.eventpublication;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
class EventPublicationIntegrationTest {
	@Autowired CustomEventPublicationService service;

	@Test
	void getIncompleteEventPubblications() {
		List<CustomEventPublication> incompleteEventPubblications = service.getIncompleteEventPubblications();
		incompleteEventPubblications.forEach(ev -> {
			Assertions.assertThat(ev).isInstanceOf(CustomEventPublication.class);
			Assertions.assertThat(ev.getCompletionDate()).isNull();
		});
	}

	@Test
	void getCompleteEventPubblications() {
		List<CustomEventPublication> incompleteEventPubblications = service.getCompleteEventPubblications();
		incompleteEventPubblications.forEach(ev -> {
			Assertions.assertThat(ev).isInstanceOf(CustomEventPublication.class);
			Assertions.assertThat(ev.getCompletionDate()).isNotNull();
		});
	}

}
