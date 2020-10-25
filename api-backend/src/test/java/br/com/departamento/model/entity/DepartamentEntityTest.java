package br.com.departamento.model.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.departamento.model.Direction;

public class DepartamentEntityTest {
	
	private DepartamentEntity departamentoEntity;
	
	@BeforeEach
	void setUp() {
		departamentoEntity = new DepartamentEntity();
	}
	
	@Test
	void test_gets_and_sets() {
		final Long id = 1l;
		final String code = "DEP1";
		final String name = "Departamento 1";
		final String address = "Local";
		final String city = "Cidade";
		final String state = "Estado";
		final Direction diretoria = Direction.EIS;
		
		assertThat(departamentoEntity).isNotNull();
		assertThat(departamentoEntity.getId()).isNull();
		assertThat(departamentoEntity.getCode()).isNull();
		assertThat(departamentoEntity.getName()).isNull();
		assertThat(departamentoEntity.getAddress()).isNull();
		assertThat(departamentoEntity.getCity()).isNull();
		assertThat(departamentoEntity.getState()).isNull();
		assertThat(departamentoEntity.getDirection()).isNull();
		
		departamentoEntity.setId(id);
		departamentoEntity.setCode(code);
		departamentoEntity.setName(name);
		departamentoEntity.setAddress(address);
		departamentoEntity.setCity(city);
		departamentoEntity.setState(state);
		departamentoEntity.setDirection(diretoria.name());
		
		assertThat(departamentoEntity.getId()).isEqualTo(id);
		assertThat(departamentoEntity.getCode()).isEqualTo(code);
		assertThat(departamentoEntity.getName()).isEqualTo(name);
		assertThat(departamentoEntity.getAddress()).isEqualTo(address);
		assertThat(departamentoEntity.getCity()).isEqualTo(city);
		assertThat(departamentoEntity.getState()).isEqualTo(state);
		assertThat(departamentoEntity.getDirection()).isEqualTo(diretoria.name());		
		
	}

}
