package br.com.fiap.ApiPetShop.repository;

import br.com.fiap.ApiPetShop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário
    // Exemplo: List<Cliente> findByNome(String nome);
}
