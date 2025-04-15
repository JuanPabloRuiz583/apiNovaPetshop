package br.com.fiap.ApiPetShop.controller;

import br.com.fiap.ApiPetShop.model.Pet;
import br.com.fiap.ApiPetShop.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pets")
public class PetController {


    @Autowired
    private PetService petService;

    @GetMapping
    @Cacheable("pets")
    public List<Pet> listarTodos() {
        return petService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> buscarPorId(@PathVariable Long id) {
        return petService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @CacheEvict(value = "pets", allEntries = true)
    public ResponseEntity<Pet> salvar(@RequestBody @Valid Pet pet) {
        Pet petSalvo = petService.salvar(pet);
        return ResponseEntity.ok(petSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (petService.buscarPorId(id).isPresent()) {
            petService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
