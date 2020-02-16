package com.luv2code.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ConfigurableHttpMethods;
import org.springframework.data.rest.core.mapping.ResourceMetadata;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

	@Autowired
	private EntityManager em;

	public DataRestConfig(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		HttpMethod[] unsupportedActions = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE };

		// Disable certain REST actions for Product
		config.getExposureConfiguration().forDomainType(Product.class)
				.withItemExposure(
						(metadata, httpMethods) -> disableHttpMethods(metadata, httpMethods, unsupportedActions))
				.withCollectionExposure(
						(metadata, httpMethods) -> disableHttpMethods(metadata, httpMethods, unsupportedActions));

		// Disable certain REST actions for Product Category
		config.getExposureConfiguration().forDomainType(ProductCategory.class)
				.withItemExposure(
						(metadata, httpMethods) -> disableHttpMethods(metadata, httpMethods, unsupportedActions))
				.withCollectionExposure(
						(metadata, httpMethods) -> disableHttpMethods(metadata, httpMethods, unsupportedActions));

		exposeIds(config);
	}

	private ConfigurableHttpMethods disableHttpMethods(ResourceMetadata metadata, ConfigurableHttpMethods httpMethods,
			HttpMethod[] unsupportedActions) {
		return httpMethods.disable(unsupportedActions);
	}

	private void exposeIds(RepositoryRestConfiguration config) {
		// Get a list of entities from the Entity Manager
		Set<EntityType<?>> entitySet = em.getMetamodel().getEntities();

		// Create a list of these entities
		List<Class<?>> entityClasses = new ArrayList<Class<?>>();
		for (EntityType<?> entityType : entitySet) {
			entityClasses.add(entityType.getJavaType());
		}

		// Return the id of the entities as part of the REST request
		config.exposeIdsFor(entityClasses.toArray(new Class[0]));
	}
}
