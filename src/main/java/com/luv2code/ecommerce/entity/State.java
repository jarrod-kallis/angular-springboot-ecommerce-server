package com.luv2code.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
//@Data -- known lombok bug when using relationships like ONE_TO_MANY & MANY_TO_ONE
@Getter // Work around for the above bug
@Setter
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToOne(optional = false)
	private Country country;
}
