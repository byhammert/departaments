package br.com.departamento.service;

import br.com.departamento.model.entity.DepartamentEntity;

public interface UpdateDepartamentUsecase {

	DepartamentEntity execute(Long id, DepartamentEntity departamentEntity);
	
}
