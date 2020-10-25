package br.com.departamento.repository.facade.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.departamento.model.entity.DepartamentEntity;
import br.com.departamento.repository.DepartamentRepository;
import br.com.departamento.repository.facade.DepartamentRepositoryFacade;

@Repository
public class DepartamentRepositoryFacadeImpl implements DepartamentRepositoryFacade {
	
	private final DepartamentRepository departamentRepository;
	
	@Autowired
	public DepartamentRepositoryFacadeImpl(DepartamentRepository departamentRepository) {
		this.departamentRepository = departamentRepository;
	}

	@Override
	public DepartamentEntity save(final DepartamentEntity departamentEntity) {
		return departamentRepository.save(departamentEntity);
	}

	@Override
	public DepartamentEntity update(final DepartamentEntity departamentEntity) {
		return departamentRepository.save(departamentEntity);
	}

	@Override
	public void delete(final Long id) {
		departamentRepository.deleteById(id);
	}

	@Override
	public List<DepartamentEntity> list() {
		return departamentRepository.findAll();
	}

	@Override
	public Optional<DepartamentEntity> findById(final Long id) {
		return departamentRepository.findById(id);
	}

}
