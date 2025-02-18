package com.dev.Zerphyis.Adopet.entidades.repository;

import com.dev.Zerphyis.Adopet.entidades.abrigo.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryAbrigo extends JpaRepository<Abrigo, UUID> {
}
