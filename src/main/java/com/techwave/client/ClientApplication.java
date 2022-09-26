package com.techwave.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.techwave.client.dao.Client;
import com.techwave.client.model.Vehicledb;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public Client client() {
		return new Client();
	}
	
	@Bean
	public final static List<Vehicledb> requests() {
		return new ArrayList<Vehicledb>();
	}
	
}
