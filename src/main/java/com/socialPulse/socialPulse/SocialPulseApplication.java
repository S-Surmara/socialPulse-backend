package com.socialPulse.socialPulse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.socialPulse.socialPulse")
public class SocialPulseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialPulseApplication.class, args);
	}

}
