package com.spring.college.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class SwaggerConfiguration {

        @Bean
        public Docket docket(){
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.spring.college.controllers"))
                    .paths(PathSelectors.any())
                    .build();
                    //.apiInfo(this.informacoesApi().build())
                    //.consumes(new HashSet<String>(Arrays.asList("application/json")))
                    //.produces(new HashSet<String>(Arrays.asList("application/json")));

    }

}
