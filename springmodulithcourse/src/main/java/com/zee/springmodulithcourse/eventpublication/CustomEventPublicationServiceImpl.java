package com.zee.springmodulithcourse.eventpublication;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomEventPublicationServiceImpl implements CustomEventPublicationService {
	private final CustomEventPublicationRepository customEventPublicationRepository;

	@Override
	public List<CustomEventPublication> getIncompleteEventPubblications() {
		return customEventPublicationRepository.getByPublicationDateNotNullAndCompletionDateIsNull();
	}

	@Override
	public List<CustomEventPublication> getCompleteEventPubblications() {
		return customEventPublicationRepository.getByPublicationDateNotNullAndCompletionDateIsNotNull();
	}

}
