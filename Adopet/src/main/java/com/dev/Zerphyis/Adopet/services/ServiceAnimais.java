package com.dev.Zerphyis.Adopet.services;

import com.dev.Zerphyis.Adopet.entidades.pets.DadosAnimais;
import com.dev.Zerphyis.Adopet.entidades.pets.Animais;
import com.dev.Zerphyis.Adopet.entidades.repository.RepositoryAnimal;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceAnimais {
    @Autowired
    RepositoryAnimal repository;


    public List<Animais> listarTodos() {
        return repository.findAll();
    }


    public Optional<Animais> buscarPorId(UUID id) {
        return repository.findById(id);
    }

    @Transient
    public Animais salvar(DadosAnimais dados) {
        Animais animal = new Animais(dados);
        return repository.save(animal);
    }

    @Transient
    public Animais atualizar(UUID id, DadosAnimais dados) {
        Optional<Animais> optionalAnimal =  repository.findById(id);
        if (optionalAnimal.isPresent()) {
            Animais animal = optionalAnimal.get();
            animal.setNome(dados.nome());
            animal.setIdade(dados.idade());
            animal.setRaca(dados.raca());
            animal.setEspecie(dados.especie());
            animal.setPeso(dados.peso());
            animal.setCor(dados.cor());
            animal.setSexo(dados.sexo());
            animal.setTipoadocao(dados.tipoadocao());
            return repository.save(animal);
        } else {
            throw new RuntimeException("Animal não encontrado com o ID: " + id);
        }
    }

    @Transient
    public void deletar(UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Animal não encontrado com o ID: " + id);
        }
    }


}
