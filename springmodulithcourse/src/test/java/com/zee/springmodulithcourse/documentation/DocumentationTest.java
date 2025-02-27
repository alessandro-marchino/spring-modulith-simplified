package com.zee.springmodulithcourse.documentation;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

import com.zee.springmodulithcourse.SpringmodulithcourseApplication;

public class DocumentationTest {
	ApplicationModules modules = ApplicationModules.of(SpringmodulithcourseApplication.class);

	@Test
	void writeDocumentationSnippets() {
		new Documenter(modules)
			.writeModulesAsPlantUml()
			.writeIndividualModulesAsPlantUml()
			.writeModuleCanvases()
			.writeAggregatingDocument();
	}
}
