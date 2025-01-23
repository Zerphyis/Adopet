package com.dev.Zerphyis.Adopet.entidades.cartelaAdocao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryDadosAdocao extends JpaRepository<Adocao, UUID> {
}
