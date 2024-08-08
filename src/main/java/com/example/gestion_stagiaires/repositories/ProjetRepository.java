package com.example.gestion_stagiaires.repositories;
import com.example.gestion_stagiaires.entities.Stagiaire;
import com.example.gestion_stagiaires.repositories.StagiaireRepository;
import com.example.gestion_stagiaires.entities.Projet;
import com.example.gestion_stagiaires.repositories.ProjetRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends MongoRepository<Projet, String> {
}