package br.com.fiap.ApiPetShop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "campo obrigatório")
    private String nome;
    @NotBlank(message = "campo obrigatório")
    private String especie;
    @NotBlank(message = "campo obrigatório")
    private String servico;


    @ManyToOne
    private  Cliente cliente;


}
