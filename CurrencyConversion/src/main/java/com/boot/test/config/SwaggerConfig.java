package com.boot.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.boot.test.controller")).paths(PathSelectors.any())
				.build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {

		return new ApiInfo("Currency Conversion", "API Reference For Developers", "1.0", "Terms of Service",
				new Contact("", "", ""), "", "", new ArrayList<>());

	}
}
