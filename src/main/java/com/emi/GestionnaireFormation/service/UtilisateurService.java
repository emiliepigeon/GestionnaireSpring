package com.emi.GestionnaireFormation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emi.GestionnaireFormation.model.Utilisateur;
import com.emi.GestionnaireFormation.repository.UtilisateurRepository;

// Je crée une classe UtilisateurService annotée @Service
@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    // Constructeur pour l’injection du repository
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // Méthode pour récupérer tous les utilisateurs
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Méthode pour récupérer un utilisateur par matricule
    public Utilisateur findByMatricule(String matricule) {
        return utilisateurRepository.findByMatricule(matricule);
    }

}
