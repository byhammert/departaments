package br.com.departamento.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.departamento.model.entity.DepartamentEntity;
import br.com.departamento.repository.facade.DepartamentRepositoryFacade;
import br.com.departamento.service.impl.CreateDepartamentUsecaseImpl;

public class CreateDepartamentUsecaseImplTest {
	
	private CreateDepartamentUsecaseImpl createDepartamentUsecaseImpl;
	private DepartamentRepositoryFacade repositoryFacade;
	
	@BeforeEach
	public void setup() {
		repositoryFacade = mock(DepartamentRepositoryFacade.class);
		createDepartamentUsecaseImpl = new CreateDepartamentUsecaseImpl(repositoryFacade);
	}
	
	@Test
	public void should_be_success() {
		when(repositoryFacade.save(Mockito.any(DepartamentEntity.class))).thenReturn(new DepartamentEntity());
		
		DepartamentEntity entity = createDepartamentUsecaseImpl.execute(new DepartamentEntity());
		
		assertThat(entity).isNotNull();
	}
	

}
