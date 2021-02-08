package com.misprojects.robertssupermarket.config;

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

/**
 * @author Ibekason Alexander Onyebuchi
 *
 */

@Configuration
@EnableSwagger2
public class DocumentationConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return  new ApiInfo("API Documentation for Robert Supermarket Sales Plugin ",
                "This Api describes the various endpoints of interacting with the Sales Plugin",
                "1.0",
                "",
                new Contact("FUTO", "http://futo.edu.ng","edu@futo.ng"),
                "",
                "",
                Collections.emptyList());
    }

}
