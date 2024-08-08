package com.example.gestion_stagiaires.service;


import com.example.gestion_stagiaires.entities.Stagiaire;
import com.example.gestion_stagiaires.repositories.StagiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StagiaireService {

    @Autowired
    private StagiaireRepository stagiaireRepository;

    public List<Stagiaire> findAll() {
        return stagiaireRepository.findAll();
    }

    public Optional<Stagiaire> findById(String id) {
        return stagiaireRepository.findById(id);
    }

    public Stagiaire save(Stagiaire stagiaire) {
        return stagiaireRepository.save(stagiaire);
    }

    public void deleteById(String id) {
        stagiaireRepository.deleteById(id);
    }

    public List<Stagiaire> findByProjetId(String projetId) {
        return stagiaireRepository.findAll().stream()
                .filter(stagiaire -> projetId.equals(stagiaire.getProjetId()))
                .toList();
    }
}