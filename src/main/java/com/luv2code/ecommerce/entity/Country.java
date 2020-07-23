package com.luv2code.ecommerce.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data // Generates the getters & setters behind the scenes
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String code;

	private String name;

	private String stateDescription;

	private String zipCodeDescription;

	@JsonIgnore
	@OneToMany(mappedBy = "country")
	private Set<State> states;
}
