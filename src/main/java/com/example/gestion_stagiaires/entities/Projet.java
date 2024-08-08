package com.example.gestion_stagiaires.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "projets")
public class Projet {
    @Id
    private String id;
    private String nom;
    private String description;
}