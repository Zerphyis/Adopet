package com.dev.Zerphyis.Adopet.entidades.repository;

import com.dev.Zerphyis.Adopet.entidades.logins.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositoryLogin extends JpaRepository<Login,String> {
    Login findByNome(String nome);
}
