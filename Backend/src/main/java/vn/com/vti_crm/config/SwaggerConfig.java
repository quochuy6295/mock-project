package vn.com.vti_crm.config;

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
	public Docket redditCloneApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("vn.com.vti_crm.web")).build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("VTI CRM Web").version("1.0").description("API for VTI CRM System")
				.contact(new Contact(": manhnh0903@gmail.com", "", "manhnh0903")).license("Apache License Version 1.0")
				.build();
	}
}