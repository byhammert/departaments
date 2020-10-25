package br.com.departamento.model.entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

/** ModelEntity arch test class. */
@AnalyzeClasses(packages = "br.com.departamento", importOptions = DoNotIncludeTests.class)
public class ModelEntityArchTest {
	
	/** Model Entity suffix name. */
	private static final String ENTITY_SUFFIX = "Entity";
	
	/** Controller package name. */
	private static final String ENTITY_PACKAGE = "..model.entity";
	
	/** Arch test to verify if classes on model entity package have naming containing Entity */
	@ArchTest
	public static final ArchRule entity_should_be_named_entity = 
		classes()
			.that()
			.resideInAPackage(ENTITY_PACKAGE)
			.should()
			.haveSimpleNameContaining(ENTITY_SUFFIX);
	
	/** Arch test to verify if just classes on model entity package have naning Entity*/
	@ArchTest
	public static final ArchRule entity_should_be_insede_entity_package = 
		classes()
			.that()
			.haveSimpleNameContaining(ENTITY_SUFFIX)
			.should()
			.resideInAPackage(ENTITY_PACKAGE);
			

}
