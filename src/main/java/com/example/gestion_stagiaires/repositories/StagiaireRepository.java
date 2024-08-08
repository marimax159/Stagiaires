package com.example.gestion_stagiaires.repositories;

import com.example.gestion_stagiaires.entities.Stagiaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StagiaireRepository extends MongoRepository<Stagiaire, String> {
}