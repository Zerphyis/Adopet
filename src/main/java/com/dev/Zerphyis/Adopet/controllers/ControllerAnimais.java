package com.dev.Zerphyis.Adopet.controllers;

import com.dev.Zerphyis.Adopet.entidades.dtos.DadosAnimais;
import com.dev.Zerphyis.Adopet.entidades.pets.Animais;
import com.dev.Zerphyis.Adopet.services.ServiceAnimais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/Animais")
public class ControllerAnimais {
    @Autowired
    private ServiceAnimais animaisService;

    @GetMapping
    public ResponseEntity<List<Animais>> listarTodos() {
        return ResponseEntity.ok(animaisService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animais> buscarPorId(@PathVariable UUID id) {
        Optional<Animais> optionalAnimal = animaisService.buscarPorId(id);
        return optionalAnimal.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Animais> salvar(@RequestBody DadosAnimais dados) {
        Animais animal = animaisService.salvar(dados);
        return ResponseEntity.status(201).body(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animais> atualizar(@PathVariable UUID id, @RequestBody DadosAnimais dados) {
        try {
            Animais animalAtualizado = animaisService.atualizar(id, dados);
            return ResponseEntity.ok(animalAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        try {
            animaisService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
