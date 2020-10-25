package br.com.departamento.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

/** ExceptionHandler arch test class. */
@AnalyzeClasses(packages = "br.com.departamento", importOptions = DoNotIncludeTests.class)
public class ExceptionHandlerArchTest {
	
	/** Handler package name. */
	private static final String HANDLER_PACKAGE = "..handler";
	
	/** Exceptions Handler package name. */
	private static final String HANDLER_EXCEPTIONS_PACKAGE = "..handler.exceptions";
	
	/** Exceptions suffix name. */
	private static final String EXCEPTIONS_SUFFIX = "Exception";
	
	/** Exceptions Handler suffix name. */
	private static final String HANDLER_EXCEPTIONS_SUFFIX = "ExceptionHandler";
	
	/** Arch test to verify if classes annotated with RestControllerAdvice on handler package
	 * inherit from ResponseEntityExceptionHandler. 
	 */
	@ArchTest
	public static final ArchRule handlers_should_be_named_ExceptionHandler = 
		classes()
			.that()
			.resideInAnyPackage(HANDLER_PACKAGE)
			.and()
			.areAnnotatedWith(RestControllerAdvice.class)
			.should()
			.haveSimpleNameEndingWith(HANDLER_EXCEPTIONS_SUFFIX)
			.andShould()
			.beAssignableTo(ResponseEntityExceptionHandler.class);
	
	/** Arch test to verify if classes on handler exceptions package have naming containing Exception. */
	@ArchTest
	public static final ArchRule exceptions_should_be_named_exception = 
		classes()
			.that()
			.resideInAPackage(HANDLER_EXCEPTIONS_PACKAGE)
			.should()
			.haveSimpleNameContaining(EXCEPTIONS_SUFFIX);
}
