package com.dev.Zerphyis.Adopet.entidades.repository;

import com.dev.Zerphyis.Adopet.entidades.tutores.Tutores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTutores extends JpaRepository<Tutores,Long> {
    Tutores findByNome(String nome);
}
