package br.com.acqio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan(basePackageClasses = { AcqioApplication.class, Jsr310JpaConverters.class })
@EnableSpringDataWebSupport
@EnableSwagger2
public class AcqioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcqioApplication.class, args);
	}

}
