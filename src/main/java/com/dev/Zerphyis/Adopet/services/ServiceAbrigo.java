package com.dev.Zerphyis.Adopet.services;

import com.dev.Zerphyis.Adopet.entidades.abrigo.Abrigo;
import com.dev.Zerphyis.Adopet.entidades.repository.RepositoryAbrigo;
import com.dev.Zerphyis.Adopet.entidades.abrigo.DadosAbrigo;
import com.dev.Zerphyis.Adopet.entidades.repository.RepositoryAnimal;
import com.dev.Zerphyis.Adopet.entidades.repository.RepositoryTutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceAbrigo {
    @Autowired
    private RepositoryAbrigo adocaoRepository;

    @Autowired
    private RepositoryAnimal petRepository;

    @Autowired
    private RepositoryTutores tutorRepository;

    public Abrigo adicionarAdocao(DadosAbrigo dados) {

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


        Abrigo abrigo = new Abrigo(dados);
        return adocaoRepository.save(abrigo);
    }

    public List<Abrigo> listarAdocoes() {
        return adocaoRepository.findAll();
    }

    public Abrigo atualizarAdocao(UUID id, DadosAbrigo dados) {
        Optional<Abrigo> adocaoOptional = adocaoRepository.findById(id);

        if (adocaoOptional.isPresent()) {
            Abrigo abrigo = adocaoOptional.get();


            abrigo.setNome(dados.nome());
            abrigo.setTelefone(dados.telefone());
            abrigo.setIdPet(dados.idPet());
            abrigo.setIdTutor(dados.idTutor());

            return adocaoRepository.save(abrigo);
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
