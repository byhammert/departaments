package br.com.departamento.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.departamento.model.CommandResponse;
import br.com.departamento.model.Message;
import br.com.departamento.model.Status;
import br.com.departamento.model.entity.DepartamentEntity;
import br.com.departamento.service.CreateDepartamentUsecase;
import br.com.departamento.service.DeleteDepartamentUsecase;
import br.com.departamento.service.ListDepartamentUsecase;
import br.com.departamento.service.UpdateDepartamentUsecase;

public class DepartamentControllerTest {
	
	private UpdateDepartamentUsecase updateDepartamentUsecase;
	private CreateDepartamentUsecase createDepartamentUsecase;
	private ListDepartamentUsecase listDepartamentUsecase;
	private DeleteDepartamentUsecase deleteDepartamentUsecase;
	private MessageSource messageSource;
	
	private DepartamentController departamentController;
	
	@BeforeEach
	public void setup() {
		updateDepartamentUsecase = mock(UpdateDepartamentUsecase.class);
		createDepartamentUsecase = mock(CreateDepartamentUsecase.class);
		listDepartamentUsecase = mock(ListDepartamentUsecase.class);
		deleteDepartamentUsecase = mock(DeleteDepartamentUsecase.class);
		messageSource = mock(MessageSource.class);
		departamentController = new DepartamentController(createDepartamentUsecase, 
															updateDepartamentUsecase, 
															listDepartamentUsecase, 
															deleteDepartamentUsecase, 
															messageSource);
	}
	
	@Test
	public void create_departament_should_be_return_status_code_CREATED() {
		when(createDepartamentUsecase.execute(Mockito.any(DepartamentEntity.class))).thenReturn(new DepartamentEntity());
		DepartamentEntity departamentEntity = new DepartamentEntity();
		
		ResponseEntity<CommandResponse<DepartamentEntity>> response = departamentController.create(departamentEntity);
		
		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getCommand()).isNotNull();
		assertThat(response.getBody().getMessage()).isNotNull();
		assertThat(response.getBody().getMessage().getStatus()).isEqualTo(Status.SUCCESS.name());
	}
	
	@Test
	public void list_departament_should_be_return_status_code_OK() {
		when(listDepartamentUsecase.execute()).thenReturn(new ArrayList<>());
		ResponseEntity<CommandResponse<List<DepartamentEntity>>> response = departamentController.list();
		
		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getCommand()).isNotNull();
		assertThat(response.getBody().getMessage()).isNotNull();
		assertThat(response.getBody().getMessage().getStatus()).isEqualTo(Status.SUCCESS.name());
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void update_departament_should_be_return_status_code_OK() {
		when(updateDepartamentUsecase.execute(Mockito.anyLong(), Mockito.any(DepartamentEntity.class))).thenReturn(new DepartamentEntity());
		DepartamentEntity departamentEntity = new DepartamentEntity();
		ResponseEntity<?> response = departamentController.update(1l, departamentEntity);
		
		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody()).isInstanceOf(CommandResponse.class);
		
		CommandResponse command = (CommandResponse) response.getBody();
		assertThat(command.getMessage()).isNotNull();
		assertThat(command.getCommand()).isNotNull();
		assertThat(command.getMessage().getStatus()).isEqualTo(Status.SUCCESS.name());
	}
	
	@Test
	public void update_departament_should_be_return_status_code_NOT_FOUND() {
		when(updateDepartamentUsecase.execute(Mockito.anyLong(), Mockito.any(DepartamentEntity.class))).thenThrow(IllegalArgumentException.class);
		DepartamentEntity departamentEntity = new DepartamentEntity();
		ResponseEntity<?> response = departamentController.update(1l, departamentEntity);
		
		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody()).isInstanceOf(Message.class);
		Message message = (Message) response.getBody();
		assertThat(message.getStatus()).isEqualTo(Status.FAILURE.name());
	}
	
	@Test
	public void delete_departament_should_be_return_status_code_OK() {
		Message message = Message.successMessage(messageSource);
		when(deleteDepartamentUsecase.execute(Mockito.anyLong())).thenReturn(message);
		ResponseEntity<Message> response = departamentController.delete(1l);
		
		assertThat(response).isNotNull();
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getStatus()).isEqualTo(Status.SUCCESS.name());
	}

}
