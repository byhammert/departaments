package br.com.departamento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.departamento.model.entity.DepartamentEntity;
import br.com.departamento.repository.facade.DepartamentRepositoryFacade;
import br.com.departamento.service.CreateDepartamentUsecase;

@Service
public class CreateDepartamentUsecaseImpl implements CreateDepartamentUsecase {
	
	private final DepartamentRepositoryFacade repositoryFacade;
	
	@Autowired
	public CreateDepartamentUsecaseImpl(DepartamentRepositoryFacade repositoryFacade) {
		this.repositoryFacade = repositoryFacade;
	}

	@Override
	public DepartamentEntity execute(final DepartamentEntity departamentEntity) {
		DepartamentEntity entity = repositoryFacade.save(departamentEntity);
		return entity;
	}

}
