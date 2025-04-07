package br.com.fiap.ApiPetShop.model;

public class Pet {
    private long id;
    private String nome;
    private String especie;
    private String servico;

    public Pet(long id, String nome, String especie, String servico) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.servico = servico;
    }
    public Pet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
}
