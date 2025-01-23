package com.dev.Zerphyis.Adopet.entidades.tutores;

import com.dev.Zerphyis.Adopet.entidades.dtos.DadosTutores;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_tutor")
public class Tutores {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String email;
    private  String senha;
    private Integer idade;

    public Tutores(DadosTutores dados) {
             this.nome=dados.nome();
             this.telefone= dados.telefone();
             this.email= dados.email();
             this.idade=dados.idade();
             this.senha= dados.senha();
    }
    public Tutores(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
