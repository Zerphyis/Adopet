package com.dev.Zerphyis.Adopet.entidades.cartelaAdocao;

import com.dev.Zerphyis.Adopet.entidades.dtos.DadosAdocao;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_Adocao")
public class Adocao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID
    )
    private UUID id;
    private String nome;
    private String telefone;
    private LocalDateTime dataAdocao;
    private UUID idPet;
    private Long idTutor;

public Adocao(){

}
public Adocao(DadosAdocao dados){
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
