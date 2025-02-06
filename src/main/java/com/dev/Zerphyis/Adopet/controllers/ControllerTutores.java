package com.dev.Zerphyis.Adopet.controllers;


import com.dev.Zerphyis.Adopet.entidades.tutores.DadosTutores;
import com.dev.Zerphyis.Adopet.entidades.tutores.Tutores;
import com.dev.Zerphyis.Adopet.services.ServiceTutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tutores")
public class ControllerTutores {
    @Autowired
    private ServiceTutores service;

    @GetMapping("/Buscar")
    public ResponseEntity<List<Tutores>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }



    @PostMapping
    public ResponseEntity<Tutores> salvar(@RequestBody DadosTutores dados) {
        Tutores tutores = service.salvar(dados);
        return ResponseEntity.status(201).body(tutores);
    }

    @PutMapping("/Atualizar/{id}")
    public ResponseEntity<Tutores> atualizar(@PathVariable Long id, @RequestBody DadosTutores dados) {
        try {
            Tutores tutoresAtualizado = service.atualizar(id, dados);
            return ResponseEntity.ok(tutoresAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/Deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
