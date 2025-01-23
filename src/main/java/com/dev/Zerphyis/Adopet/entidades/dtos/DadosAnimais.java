package com.dev.Zerphyis.Adopet.entidades.dtos;

import com.dev.Zerphyis.Adopet.entidades.pets.enums.Adocao;
import com.dev.Zerphyis.Adopet.entidades.pets.enums.Especie;
import com.dev.Zerphyis.Adopet.entidades.pets.enums.Sexo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosAnimais(UUID id,
                           @NotBlank String nome,
                           @NotBlank  String idade,
                           @NotEmpty Sexo sexo,
                           @NotEmpty Adocao tipoadocao,
                           @NotEmpty Especie especie,
                           @NotBlank String raca,
                           @NotBlank   String cor,
                           @NotNull  Double peso
) {
}
