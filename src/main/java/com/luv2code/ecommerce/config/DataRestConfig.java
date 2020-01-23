package com.luv2code.ecommerce.config;

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
	}

	private ConfigurableHttpMethods disableHttpMethods(ResourceMetadata metadata, ConfigurableHttpMethods httpMethods,
			HttpMethod[] unsupportedActions) {
		return httpMethods.disable(unsupportedActions);
	}
}
