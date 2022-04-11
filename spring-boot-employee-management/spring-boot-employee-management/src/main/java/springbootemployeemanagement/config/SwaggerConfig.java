package springbootemployeemanagement.config;

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
public class SwaggerConfig {

	@Bean
	public Docket studentApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.groupName("Employee-API")
				.select().apis(RequestHandlerSelectors.basePackage("springbootemployeemanagement.controller"))
				.build();
				
	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder().title("Employee API").description("Employee api for Employee management")
				.termsOfServiceUrl("http://fakeemployee.com").contact(new Contact("Employee API","http://fakeemplyee.com","fake@abc.com"))
				.license("Employee License").licenseUrl("http://fakeemployee.com").version("1.0")
				.build();
	}
}
