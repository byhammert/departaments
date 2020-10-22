package br.com.departamento.repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

/** Repository arch test class. */
@AnalyzeClasses(packages = "br.com.departamento", importOptions = DoNotIncludeTests.class)
public class RepositoryArchTest {
	
	/** Repository suffix name. */
	private static final String REPOSITORY_SUFFIX = "Repository";
	
	/** Repository package name. */
	private static final String REPOSITORY_PACKAGE = "..repository";
	
	/** Controller package name. */
	private static final String CONTROLLER_PACKAGE = "..controller";
	
	/** Service package name. */
	private static final String SERVICE_PACKAGE = "..service..";
	
	/** Arch test to verify if classes on repository package have naming containing Repository */
	@ArchTest
	public static final ArchRule repository_should_be_named_repository = 
		classes()
			.that()
			.resideInAPackage(REPOSITORY_PACKAGE)
			.should()
			.haveSimpleNameContaining(REPOSITORY_SUFFIX);
	
	/** Arch test to verify if classes on repository package be assignable to JpaRepository */
	@ArchTest
	public static final ArchRule repository_should_implements_JpaRepository = 
		classes()
			.that()
			.resideInAPackage(REPOSITORY_PACKAGE)
			.should()
			.beAssignableTo(JpaRepository.class);
	
	/** Arch test to verify if classes on repository package have Repository annotation. */
	@ArchTest
	public static final ArchRule repository_should_be_annotate_with_Repository = 
		classes()
			.that()
			.resideInAPackage(REPOSITORY_PACKAGE)
			.should()
			.beAnnotatedWith(Repository.class);
	
	/** Arch test to verify if classes on repository package doesn't deppends from controller or service classes. */
	@ArchTest
	public static final ArchRule controller_should_not_depends_on_repository_and_model = 
		classes()
			.that()
			.resideInAPackage(REPOSITORY_PACKAGE)
			.should()
			.dependOnClassesThat()
			.resideInAnyPackage(CONTROLLER_PACKAGE, SERVICE_PACKAGE);
	
}
