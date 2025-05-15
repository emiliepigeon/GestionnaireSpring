package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Utilisateur;

// Interface qui permet de faire des requêtes sur la table utilisateur
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Méthode personnalisée pour trouver un utilisateur par son matricule
    Utilisateur findByMatricule(String matricule);
}
