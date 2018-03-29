package com.github.adriens.eaux.baignade;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan(basePackages = {"com.github.adriens.eaux.baignade"})
@EntityScan("com.github.adriens.eaux.baignade.domain")
public class EauxBaignadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EauxBaignadesApplication.class, args);
	}
}
