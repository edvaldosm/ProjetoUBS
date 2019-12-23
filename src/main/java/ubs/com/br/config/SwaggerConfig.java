package ubs.com.br.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.service.Tag;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String API_KEY_NAME = "bearer-token";
    private static final String PRODUTO_CALCULO = "Calculo do Produto";
    private static final String DESCRICAO_PRODUTO_CALCULO = "Realiza o calculo dos produtos na base";
	  
	    @Bean
	    public Docket pessoaSpringBusinessView() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .securitySchemes(Collections.singletonList(apiKey()))
	                .groupName("business")
	                .tags(new Tag(PRODUTO_CALCULO, DESCRICAO_PRODUTO_CALCULO))
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("ubs.com.br.controller"))
	                .paths(paths())
	                .build()
	                .apiInfo(this.metaData())
	                .useDefaultResponseMessages(false);
	    }
	  
	    private Predicate<String> paths() {
	        return Predicates.not(PathSelectors.regex("/v1/admin/.*"));
	    }
	  
	    private ApiInfo metaData() {
	        return new ApiInfoBuilder().title("Spring Boot REST API")
	            .description("Employee Management REST API")
	            .contact(new Contact("Ramesh Fadatare", "www.javaguides.net", "ramesh24fadatare@gmail.com"))
	            .license("Apache 2.0")
	            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	            .version("1.0.0")
	            .build();
	    }
	    
	    private ApiKey apiKey() {
	        return new ApiKey(API_KEY_NAME, "Authorization", "header");
	    }
	    
}
