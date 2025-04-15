package br.com.fiap.ApiPetShop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "API de um petshop", description = "Aqui vai a descrição", version = "v1"))
public class ApiPetShopApplication {


	public static void main(String[] args) {
		SpringApplication.run(ApiPetShopApplication.class, args);
	}

}
