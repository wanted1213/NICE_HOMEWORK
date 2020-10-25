package com.example.demo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("서울교통공사 승하차 순위 데이터 적재 및 조회용API 개발")
                .description("[서비스운영 - IT서비스 개발] 김한별\n"
                		   + "H2 DB Console : http://localhost:8080/h2-console")
                .build();

    }

    @Bean
    public Docket commonApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("example")
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.example.demo.controller"))
                .paths(PathSelectors.ant("/home/*"))
                //.paths(PathSelectors.any())
                .build();
//				//**********
//				.securitySchemes(Arrays.asList(apiKey()))
//				.securityContexts(Arrays.asList(securityContext()));
				
    }
    
    //*****************************************************************************
//    private ApiKey apiKey() {
//        return new ApiKey("JWT", "jwt", "header");		// key : jwt
//    }
//
//    private SecurityContext securityContext() {
//        return springfox
//                .documentation
//                .spi.service
//                .contexts
//                .SecurityContext
//                .builder()
//                .securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
//    }
//    
//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
//    }
	
}