package com.dev.Zerphyis.Adopet.entidades.repository;

import com.dev.Zerphyis.Adopet.entidades.pets.Animais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryAnimal extends JpaRepository<Animais, UUID> {
}
