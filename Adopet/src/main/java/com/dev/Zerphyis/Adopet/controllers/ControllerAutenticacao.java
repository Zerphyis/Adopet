package com.dev.Zerphyis.Adopet.controllers;

import com.dev.Zerphyis.Adopet.entidades.logins.AutenticacaoDto;
import com.dev.Zerphyis.Adopet.entidades.logins.LogadoDto;
import com.dev.Zerphyis.Adopet.entidades.logins.Login;
import com.dev.Zerphyis.Adopet.entidades.logins.RespostaToken;
import com.dev.Zerphyis.Adopet.entidades.repository.RepositoryLogin;
import com.dev.Zerphyis.Adopet.entidades.repository.RepositoryTutores;
import com.dev.Zerphyis.Adopet.entidades.tutores.Tutores;
import com.dev.Zerphyis.Adopet.security.ServiceToken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class ControllerAutenticacao {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RepositoryLogin repositoryLogin;
    @Autowired
    private RepositoryTutores repositoryTutores;
    @Autowired
    private ServiceToken tokenService;
    
    @PostMapping("/auth")
    public ResponseEntity login(@RequestBody @Valid LogadoDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.nome(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Login) auth.getPrincipal());

        return ResponseEntity.ok(new RespostaToken(token));
    }


    @PostMapping("/registrar")
    public ResponseEntity register(@RequestBody @Valid AutenticacaoDto data){
        Tutores tutor = repositoryTutores.findByNome(data.nome());
        if (tutor == null) {
            return ResponseEntity.badRequest().body("Nome não encontrado nos tutores.");
        }
        if (!tutor.getSenha().equals(data.senha())) {
            return ResponseEntity.badRequest().body("Senha inválida.");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());


        Login novoUsuario = new Login(data.nome(), encryptedPassword,data.tipoLogin());

        this.repositoryLogin.save(novoUsuario);


        return ResponseEntity.ok().build();
    }
}
