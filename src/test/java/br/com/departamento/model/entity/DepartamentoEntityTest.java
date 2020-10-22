package br.com.departamento.model.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.departamento.model.DiretoriaEnum;

public class DepartamentoEntityTest {
	
	private DepartamentoEntity departamentoEntity;
	
	@BeforeEach
	void setUp() {
		departamentoEntity = new DepartamentoEntity();
	}
	
	@Test
	void test_gets_and_sets() {
		final Long id = 1l;
		final String codigo = "DEP1";
		final String nome = "Departamento 1";
		final String local = "Local";
		final String cidade = "Cidade";
		final String estado = "Estado";
		final DiretoriaEnum diretoria = DiretoriaEnum.EIS;
		
		assertThat(departamentoEntity).isNotNull();
		assertThat(departamentoEntity.getId()).isNull();
		assertThat(departamentoEntity.getCodigo()).isNull();
		assertThat(departamentoEntity.getNome()).isNull();
		assertThat(departamentoEntity.getLocal()).isNull();
		assertThat(departamentoEntity.getCidade()).isNull();
		assertThat(departamentoEntity.getEstado()).isNull();
		assertThat(departamentoEntity.getDiretoria()).isNull();
		
		departamentoEntity.setId(id);
		departamentoEntity.setCodigo(codigo);
		departamentoEntity.setNome(nome);
		departamentoEntity.setLocal(local);
		departamentoEntity.setCidade(cidade);
		departamentoEntity.setEstado(estado);
		departamentoEntity.setDiretoria(diretoria);
		
		assertThat(departamentoEntity.getId()).isEqualTo(id);
		assertThat(departamentoEntity.getCodigo()).isEqualTo(codigo);
		assertThat(departamentoEntity.getNome()).isEqualTo(nome);
		assertThat(departamentoEntity.getLocal()).isEqualTo(local);
		assertThat(departamentoEntity.getCidade()).isEqualTo(cidade);
		assertThat(departamentoEntity.getEstado()).isEqualTo(estado);
		assertThat(departamentoEntity.getDiretoria()).isEqualTo(diretoria);		
		
	}

}
