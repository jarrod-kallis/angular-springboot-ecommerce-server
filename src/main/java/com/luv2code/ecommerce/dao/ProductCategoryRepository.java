package com.luv2code.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.luv2code.ecommerce.entity.ProductCategory;

@CrossOrigin({ "http://localhost:4200" })
// The reason we specific this is because JPA will automatically add an 's' to the path, which we don't want
//                                              Name of JSON entry, /product-category
//                                              when visiting /api
// productCategory": {
//   "href": "http://localhost:8080/api/product-category{?page,size,sort}",
//   "templated": true
// },
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
