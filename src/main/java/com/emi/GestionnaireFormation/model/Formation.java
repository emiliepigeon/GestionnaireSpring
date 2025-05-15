package com.emi.GestionnaireFormation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "formation")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String libelle;

    @Column(nullable = false)
    private String numeroOffre;

    @Column(nullable = false)
    private java.sql.Date dateDebut;

    @Column(nullable = false)
    private java.sql.Date dateFin;

    @Column(nullable = false)
    private java.sql.Date dateDebutPe;

    @Column(nullable = false)
    private java.sql.Date dateFinPe;

    @Column(nullable = false)
    private Boolean statut;

    // Ajoute d'autres champs si besoin, selon ta table SQL

    // Constructeur vide obligatoire pour JPA
    public Formation() {}

    // Getters et setters
    public Long getId() { return id; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public String getNumeroOffre() { return numeroOffre; }
    public void setNumeroOffre(String numeroOffre) { this.numeroOffre = numeroOffre; }
    public java.sql.Date getDateDebut() { return dateDebut; }
    public void setDateDebut(java.sql.Date dateDebut) { this.dateDebut = dateDebut; }
    public java.sql.Date getDateFin() { return dateFin; }
    public void setDateFin(java.sql.Date dateFin) { this.dateFin = dateFin; }
    public java.sql.Date getDateDebutPe() { return dateDebutPe; }
    public void setDateDebutPe(java.sql.Date dateDebutPe) { this.dateDebutPe = dateDebutPe; }
    public java.sql.Date getDateFinPe() { return dateFinPe; }
    public void setDateFinPe(java.sql.Date dateFinPe) { this.dateFinPe = dateFinPe; }
    public Boolean getStatut() { return statut; }
    public void setStatut(Boolean statut) { this.statut = statut; }
}
