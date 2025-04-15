package br.com.fiap.ApiPetShop.repository;

import br.com.fiap.ApiPetShop.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
