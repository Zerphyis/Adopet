package com.dev.Zerphyis.Adopet.controllers;

import com.dev.Zerphyis.Adopet.entidades.cartelaAdocao.Adocao;
import com.dev.Zerphyis.Adopet.entidades.dtos.DadosAdocao;
import com.dev.Zerphyis.Adopet.services.ServiceAdocao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/Adocao")
public class ControllerAdocao {
    @Autowired
    private ServiceAdocao adocaoService;


    @PostMapping
    public ResponseEntity<Adocao> adicionarAdocao(@RequestBody DadosAdocao dados) {
        Adocao adocao = adocaoService.adicionarAdocao(dados);
        return ResponseEntity.ok(adocao);
    }


    @GetMapping
    public ResponseEntity<List<Adocao>> listarAdocoes() {
        List<Adocao> adocoes = adocaoService.listarAdocoes();
        return ResponseEntity.ok(adocoes);
    }




    @PutMapping("/{id}")
    public ResponseEntity<Adocao> atualizarAdocao(@PathVariable UUID id, @RequestBody DadosAdocao dados) {
        try {
            Adocao adocaoAtualizada = adocaoService.atualizarAdocao(id, dados);
            return ResponseEntity.ok(adocaoAtualizada);
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
