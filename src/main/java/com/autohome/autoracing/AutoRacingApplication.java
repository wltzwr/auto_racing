package com.autohome.autoracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AutoRacingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoRacingApplication.class, args);
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("AUTO RACING").description("Api接口文档").version("1.0.0dev").build();
    }

}
