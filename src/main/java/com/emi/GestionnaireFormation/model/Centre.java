package com.emi.GestionnaireFormation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entité Centre qui représente un centre de formation.
 */
@Entity
@Table(name = "centre")
public class Centre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom du centre
    @Column(nullable = false)
    private String nom;

    // Adresse postale du centre
    @Column(name = "adresse_postal", nullable = false)
    private String adressePostal;

    // Ville du centre
    @Column(nullable = false)
    private String ville;

    // Code postal du centre
    @Column(name = "code_postal", nullable = false)
    private String codePostal;

    // Numéro de téléphone du centre
    @Column(nullable = false)
    private String telephone;

    // Libellé du centre (peut être null)
    @Column(name = "libelle")
    private String libelle;

    // Adresse du centre (champ distinct de adresse_postal)
    @Column(nullable = false)
    private String adresse;

    // Statut actif ou non (bit(1) en base, Boolean ici)
    @Column(nullable = false)
    private Boolean statut;

    // Constructeur vide obligatoire pour JPA
    public Centre() {}

    // Getters et setters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getAdressePostal() { return adressePostal; }
    public void setAdressePostal(String adressePostal) { this.adressePostal = adressePostal; }
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public Boolean getStatut() { return statut; }
    public void setStatut(Boolean statut) { this.statut = statut; }
}
