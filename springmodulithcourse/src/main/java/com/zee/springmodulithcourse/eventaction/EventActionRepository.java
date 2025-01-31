package com.zee.springmodulithcourse.eventaction;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zee.springmodulithcourse.eventaction.action.Action;

@Repository
public interface EventActionRepository extends CrudRepository<EventAction, Long> {

	Optional<EventAction> getByAction(Action action);
}
