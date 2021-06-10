package com.atakancoban.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Dokuman goruntuleme url localhost:8081/swagger-ui.html

//@Api - Rest Controller dokümantasyonu.
//@ApiModel - Rest API Model dokümantasyonu
//@ApiModelProperty - Model property dokümantasyonu
//@ApiOperation - Rest method dokümantasyonu
//@ApiParam - Method parametresi dokümantasyonu
//@ApiResponse - Method Response nesnesi icin dokümantasyonu

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.atakancoban"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());

    }


    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot Swagger ornegi")
                .description("User Api Dokümantasyonu")
                .contact(new Contact("Atakan Coban", "", ""))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.12.3")
                .build();
    }

}
