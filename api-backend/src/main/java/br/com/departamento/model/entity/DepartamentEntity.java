package br.com.departamento.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.departamento.model.Direction;
import br.com.departamento.validation.constraints.ValueOfEnum;

@Entity
@Table(name = "department")
public class DepartamentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, max = 50)
	private String code;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String name;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String address;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String city;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String state;
	
	@NotNull
	@ValueOfEnum(enumClass = Direction.class)
	private String direction;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
