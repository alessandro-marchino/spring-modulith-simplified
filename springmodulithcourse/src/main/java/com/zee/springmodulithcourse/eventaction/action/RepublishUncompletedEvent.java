package com.zee.springmodulithcourse.eventaction.action;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.core.env.Environment;
import org.springframework.modulith.events.CompletedEventPublications;
import org.springframework.modulith.events.IncompleteEventPublications;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.zee.springmodulithcourse.eventaction.EventAction;
import com.zee.springmodulithcourse.eventaction.EventActionRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RepublishUncompletedEvent {
	private final EventActionRepository eventActionRepository;
	private final IncompleteEventPublications incompleteEventPublications;
	private final CompletedEventPublications completedEventPublications;
	private final Environment env;

	public void republish(Action action) {
		Optional<EventAction> optionalEventAction = eventActionRepository.getByAction(action);
		if(optionalEventAction.isPresent()) {
			log.info("Republish incomplete events for action {}", action);
			EventAction eventAction = optionalEventAction.get();
			try {
				final Class<?> actionClass = Class.forName(eventAction.getEventCanonicalName());
				incompleteEventPublications.resubmitIncompletePublications(ep -> ep.getEvent().getClass().equals(actionClass));
				completedEventPublications.deletePublicationsOlderThan(Duration.ofHours(env.getProperty("delete.event.duration", Long.class, 100L)));
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void republish(List<Action> action) {
		action.forEach(this::republish);
	}

//	@Scheduled(fixedDelay = 10L, timeUnit = TimeUnit.SECONDS)
	public void republish() {
		log.info("Republishing uncompleted events");
		for(Action action : Action.values()) {
			republish(action);
		}
	}
}
