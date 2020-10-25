package br.com.departamento.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.departamento.model.entity.DepartamentEntity;
import br.com.departamento.repository.facade.DepartamentRepositoryFacade;
import br.com.departamento.service.impl.ListDepartamentUsecaseImpl;

public class ListDepartamentUsecaseImplTest {
	
	private ListDepartamentUsecaseImpl listDepartamentUsecaseImpl;
	private DepartamentRepositoryFacade repositoryFacade;
	
	@BeforeEach
	public void setup() {
		repositoryFacade = mock(DepartamentRepositoryFacade.class);
		listDepartamentUsecaseImpl = new ListDepartamentUsecaseImpl(repositoryFacade);
	}
	
	@Test
	public void should_be_success() {
		when(repositoryFacade.list()).thenReturn(new ArrayList<>());
		
		List<DepartamentEntity> entitys = listDepartamentUsecaseImpl.execute();
		
		assertThat(entitys).isNotNull();
		assertThat(entitys).isEmpty();
	}

}
