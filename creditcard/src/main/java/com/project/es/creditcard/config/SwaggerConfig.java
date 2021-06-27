

package com.project.es.creditcard.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;


/**
 * @author Mohit
 *
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Autowired
	private Environment environment;

	@Bean
	public Docket api() {
		String host = environment.getProperty("springfox.swagger2.host");
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.project.es.creditcard.controller"))
				.build()
				.pathMapping("/")
				.apiInfo(apiInfo())
				.host(host);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Credit card API",
				"Credit card API",
				"1.0.0",
				"terms of service",
				new Contact("", "", ""),
				"Licence","", Collections.emptyList());
	}
}
	/*public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// enabling swagger-ui part for visual documentation
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}*/


