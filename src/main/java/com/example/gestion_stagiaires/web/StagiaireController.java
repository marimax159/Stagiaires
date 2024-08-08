package com.example.gestion_stagiaires.web;

import com.example.gestion_stagiaires.entities.Stagiaire;
import com.example.gestion_stagiaires.service.StagiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stagiaires")
public class StagiaireController {

    @Autowired
    private StagiaireService stagiaireService;

    @GetMapping
    public List<Stagiaire> getAllStagiaires() {
        return stagiaireService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stagiaire> getStagiaireById(@PathVariable String id) {
        return stagiaireService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Stagiaire createStagiaire(@RequestBody Stagiaire stagiaire) {
        return stagiaireService.save(stagiaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stagiaire> updateStagiaire(@PathVariable String id, @RequestBody Stagiaire stagiaire) {
        return stagiaireService.findById(id)
                .map(existingStagiaire -> {
                    stagiaire.setId(existingStagiaire.getId());
                    return ResponseEntity.ok(stagiaireService.save(stagiaire));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStagiaire(@PathVariable String id) {
        if (stagiaireService.findById(id).isPresent()) {
            stagiaireService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/projet/{projetId}")
    public List<Stagiaire> getStagiairesByProjetId(@PathVariable String projetId) {
        return stagiaireService.findByProjetId(projetId);
    }
}