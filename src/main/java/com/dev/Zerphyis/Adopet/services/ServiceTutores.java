package com.dev.Zerphyis.Adopet.services;


import com.dev.Zerphyis.Adopet.entidades.tutores.DadosTutores;

import com.dev.Zerphyis.Adopet.entidades.repository.RepositoryTutores;
import com.dev.Zerphyis.Adopet.entidades.tutores.Tutores;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTutores {

    @Autowired
    RepositoryTutores repository;

    @Transient
    public Tutores salvar(DadosTutores dados) {
        Tutores tutor = new Tutores(dados);
        return repository.save(tutor);
    }

    @Transient
    public Tutores atualizar(Long id, DadosTutores dados) {
        Optional<Tutores> optionalTutores =  repository.findById(id);
        if (optionalTutores.isPresent()) {
            Tutores tutores = optionalTutores.get();
            tutores.setNome(dados.nome());
            tutores.setTelefone(dados.telefone());
            tutores.setIdade(dados.idade());
            tutores.setEmail(dados.email());
            tutores.setSenha(dados.senha());

            return repository.save(tutores);
        } else {
            throw new RuntimeException("Tutor não encontrado com o ID: " + id);
        }
    }

    @Transient
    public void deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Tutor não encontrado com o ID: " + id);
        }
    }
    public List<Tutores> listarTodos() {
        return repository.findAll();
    }
}
