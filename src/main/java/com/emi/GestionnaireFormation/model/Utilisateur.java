package com.emi.GestionnaireFormation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Entité Utilisateur : représente un utilisateur.
 * Un utilisateur a un rôle, une formation, des infos personnelles, etc.
 */
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique

    // Champs de l'utilisateur
    private String matricule; // Numéro unique de l'utilisateur
    private String nom; // Nom de famille
    private String prenom; // Prénom
    private String adresseMail; // Email
    private String adressePostal; // Adresse postale
    private String codePostal; // Code postal
    private String ville; // Ville
    private String motDePasse; // Mot de passe (à chiffrer en vrai !)
    private Boolean statut; // true = actif, false = inactif

    // Relation ManyToOne : chaque utilisateur a une formation
    @ManyToOne
    @JoinTable(
        name = "utilisateur_formation",
        joinColumns = @JoinColumn(name = "id_utilisateur"),
        inverseJoinColumns = @JoinColumn(name = "id_formation")
    )
    private List<Formation> formation;

    // Relation ManyToOne : chaque utilisateur a un rôle
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    // Constructeur par défaut vide pour jackson
    public Utilisateur() {

    }

        // Constructeur
public Utilisateur(Long id, String matricule, String nom, String prenom, String adresseMail,String adressePostal, String codePostal, String ville, String motDePasse, Boolean statut, List<Role> role) {
        this.id = id;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.adressePostal = adressePostal;
        this.codePostal = codePostal;
        this.ville = ville;
        this.motDePasse = motDePasse;
        this.statut = statut;
        this.role = role;
}

    // Getters et setters pour tous les champs
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresseMail() { return adresseMail; }
    public void setAdresseMail(String adresseMail) { this.adresseMail = adresseMail; }

    public String getAdressePostal() { return adressePostal; }
    public void setAdressePostal(String adressePostal) { this.adressePostal = adressePostal; }

    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public Boolean getStatut() { return statut; }
    public void setStatut(Boolean statut) { this.statut = statut; }

    public List<Formation> getFormation() { return formation; }
    public void setFormation(List<Formation> formation) { this.formation = formation; }

    public List<Role> getRole() { return role; }
    public void setRole(List<Role> role) { this.role = role; }
}

// }
// public List<Role> getRoles() {
//         return roles;
//     }
//     public void setRoles(List<Role> roles) {
//         this.roles = roles;
//     }