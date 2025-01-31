package com.zee.springmodulithcourse.eventaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import com.zee.springmodulithcourse.eventaction.action.Action;
import com.zee.springmodulithcourse.eventaction.action.CustomEventMarker;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Setup implements ApplicationRunner {
	private final EventActionRepository eventActionRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
		scanner.addIncludeFilter(new AnnotationTypeFilter(CustomEventMarker.class));
		Set<BeanDefinition> beanDefs = scanner.findCandidateComponents("com.zee.springmodulithcourse");
		
		Map<String, String> eventActionMap = new HashMap<>();
		for(BeanDefinition bd : beanDefs) {
			if(bd instanceof AnnotatedBeanDefinition abd) {
				Map<String, Object> annotationAttributeMap = abd.getMetadata()
						.getAnnotationAttributes(CustomEventMarker.class.getCanonicalName());
				eventActionMap.put(annotationAttributeMap.get("value").toString(), abd.getBeanClassName());
			}
		}
		List<EventAction> eventActions = new ArrayList<>(eventActionMap.size());
		eventActionMap.forEach((k, v) -> {
			EventAction eventAction = new EventAction();
			Action action = Action.getActionByName(k);
			eventAction.setAction(action);
			eventAction.setEventCanonicalName(v);
			if(eventActionRepository.getByAction(action).isEmpty()) {
				eventActions.add(eventAction);
			}
		});
		
		if(!eventActions.isEmpty()) {
			eventActionRepository.saveAll(eventActions);
		}
	}

}
