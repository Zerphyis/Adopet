package com.dev.Zerphyis.Adopet.entidades.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record DadosAdocao(@NotBlank  String nome,
        @NotBlank String telefone,
         @NotEmpty UUID idPet,
         @NotNull Long idTutor
) {
}
