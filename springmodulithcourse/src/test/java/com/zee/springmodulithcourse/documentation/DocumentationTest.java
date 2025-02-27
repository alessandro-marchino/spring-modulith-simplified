package com.zee.springmodulithcourse.documentation;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.docs.Documenter.DiagramOptions;
import org.springframework.modulith.docs.Documenter.DiagramOptions.DiagramStyle;

import com.zee.springmodulithcourse.SpringmodulithcourseApplication;

public class DocumentationTest {
	ApplicationModules modules = ApplicationModules.of(SpringmodulithcourseApplication.class);

	@Test
	void writeDocumentationSnippets() {
		DiagramOptions diagramOptions = Documenter.DiagramOptions.defaults().withStyle(DiagramStyle.UML);
		new Documenter(modules)
			.writeModulesAsPlantUml(diagramOptions)
			.writeIndividualModulesAsPlantUml(diagramOptions)
			.writeModuleCanvases()
			.writeAggregatingDocument();
	}
}
