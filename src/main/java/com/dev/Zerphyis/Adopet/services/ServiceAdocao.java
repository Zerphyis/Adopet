package com.dev.Zerphyis.Adopet.services;

import com.dev.Zerphyis.Adopet.entidades.cartelaAdocao.Adocao;
import com.dev.Zerphyis.Adopet.entidades.cartelaAdocao.RepositoryDadosAdocao;
import com.dev.Zerphyis.Adopet.entidades.dtos.DadosAdocao;
import com.dev.Zerphyis.Adopet.entidades.pets.RepositoryAnimal;
import com.dev.Zerphyis.Adopet.entidades.tutores.RepositoryTutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceAdocao {
    @Autowired
    private RepositoryDadosAdocao adocaoRepository;

    @Autowired
    private RepositoryAnimal petRepository;

    @Autowired
    private RepositoryTutores tutorRepository;

    public Adocao adicionarAdocao(DadosAdocao dados) {

        var pet = petRepository.findById(dados.idPet())
                .orElseThrow(() -> new IllegalArgumentException("Pet não encontrado para o ID fornecido."));

        if (!pet.getTipoadocao().equals(com.dev.Zerphyis.Adopet.entidades.pets.enums.Adocao.DISPONIVEL)) {
            throw new IllegalArgumentException("Pet não está disponível para adoção.");
        }


        if (!tutorRepository.existsById(dados.idTutor())) {
            throw new IllegalArgumentException("Tutor não encontrado para o ID fornecido.");
        }


        pet.setTipoadocao(com.dev.Zerphyis.Adopet.entidades.pets.enums.Adocao.ADOTADO);
        petRepository.save(pet);


        Adocao adocao = new Adocao(dados);
        return adocaoRepository.save(adocao);
    }

    public List<Adocao> listarAdocoes() {
        return adocaoRepository.findAll();
    }

    public Adocao atualizarAdocao(UUID id, DadosAdocao dados) {
        Optional<Adocao> adocaoOptional = adocaoRepository.findById(id);

        if (adocaoOptional.isPresent()) {
            Adocao adocao = adocaoOptional.get();

            // Atualiza os dados
            adocao.setNome(dados.nome());
            adocao.setTelefone(dados.telefone());
            adocao.setIdPet(dados.idPet());
            adocao.setIdTutor(dados.idTutor());

            return adocaoRepository.save(adocao);
        } else {
            throw new IllegalArgumentException("Adoção não encontrada para o ID fornecido.");
        }
    }

    public void deletarAdocao(UUID id) {
        if (adocaoRepository.existsById(id)) {
            adocaoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Adoção não encontrada para o ID fornecido.");
        }
    }
}
