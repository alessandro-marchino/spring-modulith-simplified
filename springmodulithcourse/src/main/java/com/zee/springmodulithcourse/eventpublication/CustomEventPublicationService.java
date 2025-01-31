package com.zee.springmodulithcourse.eventpublication;

import java.util.List;

public interface CustomEventPublicationService {
	List<CustomEventPublication> getIncompleteEventPubblications();
	List<CustomEventPublication> getCompleteEventPubblications();
}
