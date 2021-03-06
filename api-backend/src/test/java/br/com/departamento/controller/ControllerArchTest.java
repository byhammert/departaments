package br.com.departamento.controller;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.springframework.web.bind.annotation.RestController;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

/** Controller arch test class. */
@AnalyzeClasses(packages = "br.com.departamento", importOptions = DoNotIncludeTests.class)
public class ControllerArchTest {

	/** Controller suffix name. */
	private static final String REPOSITORY_SUFFIX = "Controller";
	
	/** Controller package name. */
	private static final String CONTROLLER_PACKAGE = "..controller";
	
	/** Arch test to verify if classes on controller package have naming containing Controller. */
	@ArchTest
	public static final ArchRule controller_should_be_named_controller = 
		classes()
			.that()
			.resideInAPackage(CONTROLLER_PACKAGE)
			.should()
			.haveSimpleNameContaining(REPOSITORY_SUFFIX);

	/** Arch test to verify if classes on controller package have RestController annotation. */
	@ArchTest
	public static final ArchRule controller_should_be_annotate_with_RestController = 
		classes()
			.that()
			.resideInAPackage(CONTROLLER_PACKAGE)
			.should()
			.beAnnotatedWith(RestController.class);
}
