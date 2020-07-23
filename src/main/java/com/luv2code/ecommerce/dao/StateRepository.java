package com.luv2code.ecommerce.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.luv2code.ecommerce.entity.State;

@CrossOrigin({ "http://localhost:4200" })
@RepositoryRestResource(collectionResourceRel = "state", path = "state")
public interface StateRepository extends JpaRepository<State, Long> {

	// Get the states for a specific country code
	// /api/state/search/findByCountryCode?code=ZA
	Set<State> findByCountryCode(@Param("code") String code);
}
