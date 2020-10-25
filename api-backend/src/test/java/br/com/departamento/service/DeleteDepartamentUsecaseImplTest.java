package br.com.departamento.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;

import br.com.departamento.model.Message;
import br.com.departamento.model.Status;
import br.com.departamento.repository.facade.DepartamentRepositoryFacade;
import br.com.departamento.service.impl.DeleteDepartamentUsecaseImpl;

public class DeleteDepartamentUsecaseImplTest {
	
	private DeleteDepartamentUsecaseImpl deleteDepartamentUsecaseImpl;
	private DepartamentRepositoryFacade repositoryFacade;
	private MessageSource messageSource;
	
	@BeforeEach
	public void setup() {
		repositoryFacade = mock(DepartamentRepositoryFacade.class);
		messageSource = mock(MessageSource.class);
		deleteDepartamentUsecaseImpl = new DeleteDepartamentUsecaseImpl(repositoryFacade, messageSource);
	}
	
	@Test
	public void should_be_success() {
		doNothing().when(repositoryFacade).delete(Mockito.anyLong());
		
		Message message = deleteDepartamentUsecaseImpl.execute(1L);
		
		assertThat(message).isNotNull();
		assertThat(message.getStatus()).isEqualTo(Status.SUCCESS.name());
	}
	

}
