package br.com.departamento.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class Message {
	
	private final static String PROPERTIE_SUCCESS_MESSAGE = "success-message";
	private final static String PROPERTIE_GENERIC_ERRO_MESSAGE = "generic-error-message";
	
	private final String status;
	private final List<String> messages;
	
	public Message(String status, List<String> messages) {
		this.status = status;
		this.messages = messages;
	}
	
	public String getStatus() {
		return status;
	}
	
	public List<String> getMessages() {
		return messages;
	}
	
	public static Message successMessage(final MessageSource messageSource) {
		final String message = messageSource.getMessage(PROPERTIE_SUCCESS_MESSAGE, null, LocaleContextHolder.getLocale());
		final List<String> messages = Arrays.asList(message);
		return new Message(Status.SUCCESS.name(), messages);
	}
	
	public static Message failureMessage(final String message) {
		final List<String> messages = Arrays.asList(message);
		return new Message(Status.FAILURE.name(), messages);
	}
	
	public static Message failureMessage(final List<String> messages) {
		return new Message(Status.FAILURE.name(), messages);
	}
	
	public static Message genirecErroMessage(final MessageSource messageSource) {
		final String message = messageSource.getMessage(PROPERTIE_GENERIC_ERRO_MESSAGE, null, LocaleContextHolder.getLocale());
		final List<String> messages = Arrays.asList(message);
		return new Message(Status.FAILURE.name(), messages);
	}

	@Override
	public String toString() {
		return "MessageEntity [status=" + status + ", messages=" + messages + "]";
	}

}
