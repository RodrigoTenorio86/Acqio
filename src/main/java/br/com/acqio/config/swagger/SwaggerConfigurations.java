package br.com.acqio.config.swagger;
//http://localhost:8080/transaction/v2/api-docs
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigurations {
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
                .apis(RequestHandlerSelectors.basePackage("br.com.acqio.endpoint"))
                .build()
                .apiInfo(metaData());
    }
    
    private ApiInfo metaData() {
    	return new ApiInfoBuilder()
    			.title("Api Rest Acqio")
    			.description("Service Rest Api")
    			.version("v1.0")
    			.contact(new Contact("Rodrigo Tenorio de Boa Ventura", "https://github.com/RodrigoTenorio86", "boaventura19@yahoo.com.br"))
    			.license("MIT")
    			.build();
    }

}
