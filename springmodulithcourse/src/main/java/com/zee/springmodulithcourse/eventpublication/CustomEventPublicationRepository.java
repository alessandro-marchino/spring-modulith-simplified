package com.zee.springmodulithcourse.eventpublication;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomEventPublicationRepository extends CrudRepository<CustomEventPublication, UUID> {

	List<CustomEventPublication> getByPublicationDateNotNullAndCompletionDateIsNull();
	List<CustomEventPublication> getByPublicationDateNotNullAndCompletionDateIsNotNull();
}
