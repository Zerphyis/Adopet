package com.dev.Zerphyis.Adopet.entidades.abrigo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosAbrigo(@NotBlank String nome,
                          @NotBlank String telefone,
                          @NotNull UUID idPet,
                          @NotNull Long idTutor
) {
}
