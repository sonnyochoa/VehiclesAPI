package com.udacity.vehicles.config;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code=401, message = "Due to security constraints, your access request cannot be authorized."),
        @ApiResponse(code=500, message = "The server is down. Please make sure that the Price microservice is running.")
})
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Vehicles API",
                "This API returns a list of car with their descriptive details.",
                "1.0",
                "https://www.sonnylife.dev",
                new Contact("Sonny Ochoa", "https://www.sonnylife.dev", "create@sonnylife.dev"),
                "License of API", "https://www.sonnylife.dev/license", Collections.emptyList()
        );
    }
}
