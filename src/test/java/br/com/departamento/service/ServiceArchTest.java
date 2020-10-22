package br.com.departamento.service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.springframework.stereotype.Service;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

/** Seervice arch test class. */
@AnalyzeClasses(packages = "br.com.departamento", importOptions = DoNotIncludeTests.class)
public class ServiceArchTest {
	
	/** Controller suffix name. */
	private static final String SERVICE_SUFFIX = "Usecase";
	
	/** Controller suffix name. */
	private static final String SERVICE_IMPL_SUFFIX = "Impl";
	
	/** Service package name. */
	private static final String SERVICE_PACKAGE = "..service";
	
	/** Service Impl package name. */
	private static final String SERVICE_IMPL_PACKAGE = "..service.impl";
	
	/** Controller package name. */
	private static final String CONTROLLER_PACKAGE = "..controller";
	
	/** Arch test to verify if classes on service package have naming containing Usecase */
	@ArchTest
	public static final ArchRule service_should_be_named_usecase = 
		classes()
			.that()
			.resideInAPackage(SERVICE_PACKAGE)
			.should()
			.haveSimpleNameContaining(SERVICE_SUFFIX);
	
	/** Arch test to verify if classes on service.impl package have naming containing Usecase and Impl */
	@ArchTest
	public static final ArchRule service_impl_should_be_named_usecaseimpl = 
		classes()
			.that()
			.resideInAPackage(SERVICE_IMPL_PACKAGE)
			.should()
			.haveSimpleNameContaining(SERVICE_SUFFIX)
			.andShould()
			.haveSimpleNameEndingWith(SERVICE_IMPL_SUFFIX);
	
	/** Arch test to verify if classes on service package be accessed from controller classes. */
	@ArchTest
	public static final ArchRule controller_should_not_depends_on_repository_and_model = 
		classes()
			.that()
			.resideInAPackage(SERVICE_PACKAGE)
			.should()
			.onlyBeAccessed()
			.byClassesThat()
			.resideInAnyPackage(CONTROLLER_PACKAGE);
	
	/** Arch test to verify if classes on service.impl package have Service annotation. */
	@ArchTest
	public static final ArchRule controller_should_be_annotate_with_RestController = 
		classes()
			.that()
			.resideInAPackage(SERVICE_IMPL_PACKAGE)
			.should()
			.beAnnotatedWith(Service.class);
}
