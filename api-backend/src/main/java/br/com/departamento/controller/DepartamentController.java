package br.com.departamento.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.departamento.model.CommandResponse;
import br.com.departamento.model.Message;
import br.com.departamento.model.entity.DepartamentEntity;
import br.com.departamento.service.CreateDepartamentUsecase;
import br.com.departamento.service.DeleteDepartamentUsecase;
import br.com.departamento.service.ListDepartamentUsecase;
import br.com.departamento.service.UpdateDepartamentUsecase;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/departments")
public class DepartamentController {
	
	private final static String PROPERTIE_RESOURCE_NOT_FOUND = "resource.not-found";
	
	private final CreateDepartamentUsecase createDepartamentUsecase;
	private final UpdateDepartamentUsecase updateDepartamentUsecase;
	private final ListDepartamentUsecase listDepartamentUsecase;
	private final DeleteDepartamentUsecase deleteDepartamentUsecase;
	private final MessageSource messageSource;
	
	@Autowired
	public DepartamentController(CreateDepartamentUsecase createDepartamentUsecase,
									UpdateDepartamentUsecase updateDepartamentUsecase,
									ListDepartamentUsecase listDepartamentUsecase,
									DeleteDepartamentUsecase deleteDepartamentUsecase,
									MessageSource messageSource) {
		this.createDepartamentUsecase = createDepartamentUsecase;
		this.updateDepartamentUsecase = updateDepartamentUsecase;
		this.listDepartamentUsecase = listDepartamentUsecase;
		this.deleteDepartamentUsecase = deleteDepartamentUsecase;
		this.messageSource = messageSource;
	}
	
	@GetMapping()
	public ResponseEntity<CommandResponse<List<DepartamentEntity>>> list() {
		final List<DepartamentEntity> departments = listDepartamentUsecase.execute();
		final CommandResponse<List<DepartamentEntity>> response = new CommandResponse<List<DepartamentEntity>>(departments, Message.successMessage(messageSource));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping()
	public ResponseEntity<CommandResponse<DepartamentEntity>> create(@Valid @RequestBody DepartamentEntity request) {
		final DepartamentEntity departamentEntity = createDepartamentUsecase.execute(request);
		final Message message = Message.successMessage(messageSource);
		final CommandResponse<DepartamentEntity> response = new CommandResponse<DepartamentEntity>(departamentEntity, message);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody DepartamentEntity request) {
		try {
			final DepartamentEntity departamentEntity = updateDepartamentUsecase.execute(id, request);
			final Message message = Message.successMessage(messageSource);
			final CommandResponse<DepartamentEntity> response = new CommandResponse<DepartamentEntity>(departamentEntity, message);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (IllegalArgumentException e) {
			final String message = messageSource.getMessage(PROPERTIE_RESOURCE_NOT_FOUND, null, LocaleContextHolder.getLocale());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Message.failureMessage(message));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Message> delete(@PathVariable Long id) {
		final Message messageResponseEntity = deleteDepartamentUsecase.execute(id);
		return ResponseEntity.status(HttpStatus.OK).body(messageResponseEntity);
	}

}
