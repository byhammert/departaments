package br.com.departamento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.departamento.model.entity.DepartamentEntity;
import br.com.departamento.repository.facade.DepartamentRepositoryFacade;
import br.com.departamento.service.ListDepartamentUsecase;

@Service
public class ListDepartamentUsecaseImpl implements ListDepartamentUsecase {

	private final DepartamentRepositoryFacade repositoryFacade;
	
	@Autowired
	public ListDepartamentUsecaseImpl(DepartamentRepositoryFacade repositoryFacade) {
		this.repositoryFacade = repositoryFacade;
	}
	
	@Override
	public List<DepartamentEntity> execute() {
		return repositoryFacade.list();
	}

}
