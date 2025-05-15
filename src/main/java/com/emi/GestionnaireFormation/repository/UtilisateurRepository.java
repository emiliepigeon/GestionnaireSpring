package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Utilisateur;

/**
 * Repository pour l'entité Utilisateur.
 * Permet de faire toutes les opérations CRUD sur la table utilisateur.
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
    Utilisateur findByMatricule(String matricule);
}
