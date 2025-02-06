package com.dev.Zerphyis.Adopet.entidades.tutores;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosTutores(@NotBlank  String nome,
                           @NotBlank String telefone,
                           @NotBlank  String email,
                           @NotBlank  String senha,
                           @NotNull  Integer idade ) {
}
