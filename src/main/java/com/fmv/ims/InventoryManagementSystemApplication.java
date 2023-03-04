package com.fmv.ims;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementSystemApplication.class, args);
		System.out.println("IMS_Server Started");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
