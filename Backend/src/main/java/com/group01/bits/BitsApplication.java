package com.group01.bits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = "com.group01.bits")
@EntityScan("com.group01.bits")
@EnableConfigurationProperties
public class BitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitsApplication.class, args);
	}

}
