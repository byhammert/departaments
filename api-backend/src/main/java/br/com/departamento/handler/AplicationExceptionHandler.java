package br.com.departamento.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.departamento.model.Message;

@ControllerAdvice
public class AplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	private final static String PROPERTIE_RESOURCE_NOT_FOUND = "resource.not-found";
	
	private final static Logger LOGGER = LoggerFactory.getLogger(AplicationExceptionHandler.class);
	
	private final MessageSource messageSource;
	
	@Autowired
	public AplicationExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		final Message messageResponseEntity = Message.genirecErroMessage(messageSource);
		LOGGER.error(messageResponseEntity.getMessages().toString(), ex);
		return handleExceptionInternal(ex, messageResponseEntity, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		final List<String> erros = criarListaDeErros(ex.getBindingResult());
		final Message messageResponseEntity = Message.failureMessage(erros);
		LOGGER.warn(messageResponseEntity.getMessages().toString());
		return handleExceptionInternal(ex, messageResponseEntity, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handleEmptyResultDataAccessException(final EmptyResultDataAccessException ex, final WebRequest request) {
		final String message = messageSource.getMessage(PROPERTIE_RESOURCE_NOT_FOUND, null, LocaleContextHolder.getLocale());
		final Message messageResponseEntity = Message.failureMessage(message);
		LOGGER.warn(messageResponseEntity.getMessages().toString());
		return handleExceptionInternal(ex, messageResponseEntity, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	private List<String> criarListaDeErros(final BindingResult bindingResult) {
		final List<String> erros = new ArrayList<>();
		
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			erros.add(messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()));
		}
			
		return erros;
	}
	
}
