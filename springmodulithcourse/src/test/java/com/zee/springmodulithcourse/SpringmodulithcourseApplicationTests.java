package com.zee.springmodulithcourse;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
class SpringmodulithcourseApplicationTests {

	@Test
	void contextLoads() {
		ApplicationModules.of(SpringmodulithcourseApplication.class).verify();
	}

}
