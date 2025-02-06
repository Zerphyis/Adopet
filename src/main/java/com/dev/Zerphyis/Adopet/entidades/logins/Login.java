package com.dev.Zerphyis.Adopet.entidades.logins;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "tb_login")
@Entity
public class Login implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank
    private String nome;
    @NotBlank
    private String senha;
    @NotNull
    @Enumerated(EnumType.STRING)
    private  TipoLogin tipoLogin;

public  Login(){

}

    public Login(String nome, String senha, TipoLogin tipoLogin) {
        this.nome = nome;
        this.senha = senha;
        this.tipoLogin = tipoLogin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.tipoLogin == TipoLogin.GERENTE) return List.of(new SimpleGrantedAuthority("GERENTE"), new SimpleGrantedAuthority("TUTOR"));
        else return List.of(new SimpleGrantedAuthority("TUTOR"));
    }


    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoLogin getTipoLogin() {
        return tipoLogin;
    }

    public void setTipoLogin(TipoLogin tipoLogin) {
        this.tipoLogin = tipoLogin;
    }

    @Override
    public boolean isEnabled() {
        return true;

    }
}
