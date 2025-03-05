package com.fiap.RM358568.edusocrates.controle_restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.fiap.RM358568.edusocrates.controle_restaurante")
public class ControleRestauranteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleRestauranteApplication.class, args);
	}

}
