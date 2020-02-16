package com.luv2code.ecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.ecommerce.entity.Product;

/**
 * Spring magically produces CRUD endpoints when extending JpaRepository. It can
 * also produce endpoints based on the naming convention of your methods.
 * 
 * @author Jarrod
 *
 */
@CrossOrigin({ "http://localhost:4200" })
@RepositoryRestResource(collectionResourceRel = "product", path = "product")
//                                                       Entity, Id Type
public interface ProductRepository extends JpaRepository<Product, Long> {

	/*
	 * endpoint: product/search/findByCategoryId?id=1
	 * 
	 * select * from product left outer join product_category where
	 * product_category.id = 1
	 */
	public Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

	/*
	 * endpoint: product/search/findByNameContaining?name=python
	 * 
	 * select * from product where name like %python%
	 */
	public Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
