package br.com.departamento.repository.facade;

import java.util.List;
import java.util.Optional;

import br.com.departamento.model.entity.DepartamentEntity;

public interface DepartamentRepositoryFacade {
	
	DepartamentEntity save(DepartamentEntity departamentEntity);
	DepartamentEntity update(DepartamentEntity departamentEntity);
	void delete(Long id);
	List<DepartamentEntity> list();
	Optional<DepartamentEntity> findById(Long id);

}
