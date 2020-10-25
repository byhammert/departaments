package br.com.departamento.model;

public class CommandResponse<T> {
	
	private final Message message;
	private final T command;
	
	public CommandResponse(T command, Message message) {
		super();
		this.command = command;
		this.message = message;
	}
	
	public T getCommand() {
		return command;
	}
	
	public Message getMessage() {
		return message;
	}

	public static <T> CommandResponse<T> of(T command, Message message) {
		return new CommandResponse<>(command, message);
	}

}
