package com.dev.Zerphyis.Adopet.services;

import com.dev.Zerphyis.Adopet.entidades.repository.RepositoryLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServiceAuthenticacao  implements UserDetailsService {
    @Autowired
    RepositoryLogin repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByNome(username);
    }
}
