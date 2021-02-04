package br.com.portfolio.lottery.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@EnableWebMvc
@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI springOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Lottery API")
						.description("Spring Lottery API sample application")
						.version("v1.0")
						.contact(new Contact()
								.name("Felipe Gadelha Diniz Da Silva")
								.url("https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/")
								.email("felipegadelha90@gmail.com"))
						.license(new License()
								.name("Apache 2.0")
								.url("https://www.apache.org/licenses/LICENSE-2.0")))
				.externalDocs(new ExternalDocumentation()
						.description("Spring Lottery Github Documentation")
						.url("https://github.com/FelipeGadelha/lottery-api"));

	}

}