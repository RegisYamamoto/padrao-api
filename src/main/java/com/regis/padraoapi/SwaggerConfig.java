package com.regis.padraoapi;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

// http://localhost:8080/swagger-ui.html#/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.regis.padraoapi"))
                .paths(regex("/padraoapi.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

		@SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo(
                "Padrao API REST",
                "API REST padrão",
                "1.0",
                "Terms of Service",
                new Contact("Regis Yamamoto", "https://www.regisyamamoto.com.br",
                        "regisyamamoto@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
}
