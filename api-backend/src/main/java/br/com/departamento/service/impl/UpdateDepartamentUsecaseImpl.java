package br.com.departamento.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.departamento.model.entity.DepartamentEntity;
import br.com.departamento.repository.facade.DepartamentRepositoryFacade;
import br.com.departamento.service.UpdateDepartamentUsecase;

@Service
public class UpdateDepartamentUsecaseImpl implements UpdateDepartamentUsecase {

	private final static String ID_ATTRIBUTE = "id";
	
	private final DepartamentRepositoryFacade repositoryFacade;
	
	@Autowired
	public UpdateDepartamentUsecaseImpl(DepartamentRepositoryFacade repositoryFacade) {
		this.repositoryFacade = repositoryFacade;
	}
	
	@Override
	public DepartamentEntity execute(final Long id, final DepartamentEntity departamentEntity) {
		final DepartamentEntity departamentEntitySave = findDepartament(id);
		BeanUtils.copyProperties(departamentEntity, departamentEntitySave, ID_ATTRIBUTE);
		return repositoryFacade.update(departamentEntitySave);
	}
	
	private DepartamentEntity findDepartament(final Long id) {
		final Optional<DepartamentEntity> departament = repositoryFacade.findById(id);
		if (!departament.isPresent()) {
			throw new IllegalArgumentException();
		}
		return departament.get();
	}

}
