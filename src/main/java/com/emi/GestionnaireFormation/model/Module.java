package com.emi.GestionnaireFormation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entité Module qui représente un module de formation.
 */
@Entity
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Libelle du module
    @Column(nullable = false)
    private String libelle;


    // Description du module
    @Column(nullable = false)
    private String description;

    // Nom du module
    @Column(nullable = false)
    private String nom;

    // Statut actif ou non
    @Column(nullable = false)
    private Boolean statut;

    // Constructeur vide obligatoire pour JPA
    public Module() {}

    // Getters et setters
    public Long getId() { return id; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Boolean getStatut() { return statut; }
    public void setStatut(Boolean statut) { this.statut = statut; }
}
