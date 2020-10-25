package br.com.departamento.handler;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.MessageSource;

public class AplicationExceptionHandlerTest {
	
	private AplicationExceptionHandler aplicationExceptionHandler;
	private MessageSource messageSource;
	
	@BeforeEach
	public void setup() {
		messageSource = mock(MessageSource.class);
		aplicationExceptionHandler = new AplicationExceptionHandler(messageSource);
	}
	

}
