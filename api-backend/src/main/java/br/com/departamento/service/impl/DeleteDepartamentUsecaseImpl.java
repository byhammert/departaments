package br.com.departamento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import br.com.departamento.model.Message;
import br.com.departamento.repository.facade.DepartamentRepositoryFacade;
import br.com.departamento.service.DeleteDepartamentUsecase;

@Service
public class DeleteDepartamentUsecaseImpl implements DeleteDepartamentUsecase {

	private final DepartamentRepositoryFacade repositoryFacade;
	private final MessageSource messageSource;
	
	@Autowired
	public DeleteDepartamentUsecaseImpl(DepartamentRepositoryFacade repositoryFacade, MessageSource messageSource) {
		this.repositoryFacade = repositoryFacade;
		this.messageSource = messageSource;
	}
	
	@Override
	public Message execute(final Long id) {
		repositoryFacade.delete(id);
		return Message.successMessage(messageSource);
	}

}
