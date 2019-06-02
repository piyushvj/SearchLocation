package com.searchlocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SearchlocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchlocationApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplet(){
		return new RestTemplate();
	}

}
