package com.dev.Zerphyis.Adopet.controllers;

import com.dev.Zerphyis.Adopet.entidades.abrigo.Abrigo;
import com.dev.Zerphyis.Adopet.entidades.abrigo.DadosAbrigo;
import com.dev.Zerphyis.Adopet.services.ServiceAbrigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Abrigo")
public class ControllerAbrigo {
    @Autowired
    private ServiceAbrigo adocaoService;


    @PostMapping
    public ResponseEntity<Abrigo> adicionarAdocao(@RequestBody DadosAbrigo dados) {
        Abrigo abrigo = adocaoService.adicionarAdocao(dados);
        return ResponseEntity.ok(abrigo);
    }


    @GetMapping
    public ResponseEntity<List<Abrigo>> listarAdocoes() {
        List<Abrigo> adocoes = adocaoService.listarAdocoes();
        return ResponseEntity.ok(adocoes);
    }




    @PutMapping("/{id}")
    public ResponseEntity<Abrigo> atualizarAdocao(@PathVariable UUID id, @RequestBody DadosAbrigo dados) {
        try {
            Abrigo abrigoAtualizada = adocaoService.atualizarAdocao(id, dados);
            return ResponseEntity.ok(abrigoAtualizada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdocao(@PathVariable UUID id) {
        try {
            adocaoService.deletarAdocao(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
