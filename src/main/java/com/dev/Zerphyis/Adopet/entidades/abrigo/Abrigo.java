package com.dev.Zerphyis.Adopet.entidades.abrigo;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_Adocao")
public class Abrigo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @FutureOrPresent
    private LocalDateTime dataAdocao;
    @NotEmpty
    private UUID idPet;
    @NotNull
    private Long idTutor;

public Abrigo(){

}
public Abrigo(DadosAbrigo dados){
    this.nome= dados.nome();
    this.telefone= dados.telefone();
    this.dataAdocao=LocalDateTime.now();
    this.idPet=dados.idPet();
    this.idTutor= dados.idTutor();

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(LocalDateTime dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    public UUID getIdPet() {
        return idPet;
    }

    public void setIdPet(UUID idPet) {
        this.idPet = idPet;
    }

    public Long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }
}
