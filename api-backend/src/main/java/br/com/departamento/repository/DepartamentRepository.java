package br.com.departamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.departamento.model.entity.DepartamentEntity;

@Repository
public interface DepartamentRepository extends JpaRepository<DepartamentEntity, Long>{

}
