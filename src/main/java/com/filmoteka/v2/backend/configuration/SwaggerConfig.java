package com.filmoteka.v2.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(apiKey()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Filmoteka")
                .version("1.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("apiKey", "Authorization", ApiKeyVehicle.HEADER.getValue());
    }
}

//    @Bean
//    SecurityConfiguration security() {
//        return new SecurityConfiguration(
//                null,
//                SECRET,
//                null,
//                null,
//                "Bearer ",
//                ApiKeyVehicle.HEADER,
//                "Authorization",
//                ","
//        );
//    }
//
//    ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Filmoteka")
//                .build();
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey("Bearer", "Authorization", ApiKeyVehicle.HEADER.getValue());
//    }
//
//
//    private SecurityReference securityReference() {
//        return SecurityReference.builder()
//                .reference("Authorization")
//                .scopes(new AuthorizationScope[0])
//                .build();
//
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(Arrays.asList(securityReference()))
//                .build();
//
//    }


