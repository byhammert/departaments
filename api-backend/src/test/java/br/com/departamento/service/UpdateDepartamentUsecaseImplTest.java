package br.com.departamento.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.departamento.model.entity.DepartamentEntity;
import br.com.departamento.repository.facade.DepartamentRepositoryFacade;
import br.com.departamento.service.impl.UpdateDepartamentUsecaseImpl;

public class UpdateDepartamentUsecaseImplTest {

	private UpdateDepartamentUsecaseImpl updateDepartamentUsecaseImpl;
	private DepartamentRepositoryFacade repositoryFacade;
	
	@BeforeEach
	public void setup() {
		repositoryFacade = mock(DepartamentRepositoryFacade.class);
		updateDepartamentUsecaseImpl = new UpdateDepartamentUsecaseImpl(repositoryFacade);
	}
	
	@Test
	public void should_be_success() {
		when(repositoryFacade.findById(Mockito.anyLong())).thenReturn(Optional.of(new DepartamentEntity()));
		when(repositoryFacade.update(Mockito.any(DepartamentEntity.class))).thenReturn(new DepartamentEntity());
		
		DepartamentEntity entity = updateDepartamentUsecaseImpl.execute(1l, new DepartamentEntity());
		
		assertThat(entity).isNotNull();
	}
	
	@Test
	public void should_be_IllegalArgumentException() {
		assertThatThrownBy(() -> {
			when(repositoryFacade.findById(Mockito.anyLong())).thenReturn(Optional.empty());
			updateDepartamentUsecaseImpl.execute(1l, new DepartamentEntity());
		})
		.isExactlyInstanceOf(IllegalArgumentException.class);
	}
	
}
