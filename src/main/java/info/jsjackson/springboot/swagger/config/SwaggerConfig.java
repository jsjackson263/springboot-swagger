package info.jsjackson.springboot.swagger.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

  @Value("${info.build.version}")
  private String versionNumber;

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("info.jsjackson.springboot.swagger"))
                .paths(regex("/rest.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot Swagger Example API",
                "An example Spring Boot Integration with Swagger",
                "1.0",
                "Terms of Service",
                new Contact("TechPrimers", "https://www.example.com",
                        "owner@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/"
        );

        ApiInfo apiMeta = new ApiInfoBuilder()
            .title("Spring Boot Swagger Example API")
            .description( "An example Spring Boot Integration with Swagger")
            .version(versionNumber)
            .license("Terms of Service")
            .licenseUrl("https://www.apache.org/licenses/")
            .contact(new Contact("Jov Sample Apps", "https://www.example.com", "owner@gmail.com"))
            .build();
        
        return apiMeta;
    }
}
