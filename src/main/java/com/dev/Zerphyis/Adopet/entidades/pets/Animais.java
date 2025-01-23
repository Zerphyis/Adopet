package com.dev.Zerphyis.Adopet.entidades.pets;

import com.dev.Zerphyis.Adopet.entidades.dtos.DadosAnimais;
import com.dev.Zerphyis.Adopet.entidades.pets.enums.Adocao;
import com.dev.Zerphyis.Adopet.entidades.pets.enums.Especie;
import com.dev.Zerphyis.Adopet.entidades.pets.enums.Sexo;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_animais")
public class Animais {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String idade;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Enumerated(EnumType.STRING)
    private Especie especie;
    private String raca;
    private  String cor;
    private  Double peso;
    @Enumerated(EnumType.STRING)
    private Adocao tipoadocao;

    public Animais(DadosAnimais dados ) {
            this.nome=dados.nome();
            this.idade=dados.idade();
            this.raca=dados.raca();
            this.especie=dados.especie();
            this.peso= dados.peso();
            this.cor=dados.cor();
            this.sexo=dados.sexo();
            this.tipoadocao=dados.tipoadocao();

    }

    public Animais( ) {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Adocao getTipoadocao() {
        return tipoadocao;
    }

    public void setTipoadocao(Adocao tipoadocao) {
        this.tipoadocao = tipoadocao;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
