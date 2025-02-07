package com.zee.springmodulithcourse.eventaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

import com.zee.springmodulithcourse.eventaction.action.Action;
import com.zee.springmodulithcourse.eventaction.action.RepublishUncompletedEvent;

@ApplicationModuleTest
class EventActionIntegrationTest {
	
	@Autowired
	RepublishUncompletedEvent republishUncompletedEvent;

	@Test
	void verifyModule() {
		// Nothing
	}

	@Test
	void testUncompletedEvents() {
		republishUncompletedEvent.republish(Action.PAYMENT);
	}

}
