package com.luv2code.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.luv2code.ecommerce.entity.Product;

@CrossOrigin({ "http://localhost:4200" })
@RepositoryRestResource(collectionResourceRel = "product", path = "product")
//                                                       Entity, Id Type
public interface ProductRepository extends JpaRepository<Product, Long> {

}
