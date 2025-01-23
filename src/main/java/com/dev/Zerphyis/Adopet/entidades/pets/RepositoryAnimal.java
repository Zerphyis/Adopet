package com.dev.Zerphyis.Adopet.entidades.pets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryAnimal extends JpaRepository<Animais, UUID> {
}
