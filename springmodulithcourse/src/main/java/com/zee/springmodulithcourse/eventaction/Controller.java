package com.zee.springmodulithcourse.eventaction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.springmodulithcourse.eventaction.action.Action;
import com.zee.springmodulithcourse.eventaction.action.RepublishUncompletedEvent;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("event-action")
public class Controller {
	private final RepublishUncompletedEvent republishUncompletedEvent;

	@GetMapping
	public ResponseEntity<String> republishEvent(String action) {
		republishUncompletedEvent.republish(Action.getActionByName(action));
		return new ResponseEntity<String>("Event triggered", HttpStatus.NO_CONTENT);
	}

}
