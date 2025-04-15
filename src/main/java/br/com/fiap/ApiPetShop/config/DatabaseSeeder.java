package br.com.fiap.ApiPetShop.config;

import br.com.fiap.ApiPetShop.model.Pet;
import br.com.fiap.ApiPetShop.repository.PetRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseSeeder {

    @Autowired
    private PetRepository petRepository;

    @PostConstruct
    public void init() {
        var pets = List.of(
                Pet.builder()
                        .nome("Rex")
                        .especie("Cachorro")
                        .servico("Banho e Tosa")
                        .build(),
                Pet.builder()
                        .nome("Mimi")
                        .especie("Gato")
                        .servico("Consulta Veterinária")
                        .build()

        );
        petRepository.saveAll(pets);
    }

}
