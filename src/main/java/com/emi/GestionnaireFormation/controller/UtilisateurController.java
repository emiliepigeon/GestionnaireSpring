package com.emi.GestionnaireFormation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.model.Utilisateur;
import com.emi.GestionnaireFormation.repository.FormationRepository;
import com.emi.GestionnaireFormation.repository.RoleRepository;
import com.emi.GestionnaireFormation.repository.UtilisateurRepository;

/**
 * Contrôleur REST pour l'entité Utilisateur.
 * Toutes les méthodes renvoient du JSON.
 */
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;
    private final FormationRepository formationRepository;

    public UtilisateurController( UtilisateurRepository utilisateurRepository, RoleRepository roleRepository,FormationRepository formationRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
        this.formationRepository = formationRepository;
    }

    // GET /api/utilisateurs : récupère tous les utilisateurs
    @GetMapping("/")
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }


    // GET Récupère un utilisateur par matricule
    @GetMapping("/{matricule}")
    public Utilisateur findByMatricule(@PathVariable String matricule) {
        return utilisateurRepository.findByMatricule(matricule);
    }

    // Crée un nouvel utilisateur
    @PostMapping("/create")
    public void add(@RequestBody Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    // PUT /api/utilisateurs/{id} : modifie un utilisateur existant
    // Met à jour un utilisateur existant
    @PutMapping("/update/{matricule}")
    public void update(@PathVariable String matricule, @RequestBody Utilisateur utilisateur) {
        Utilisateur existingUser = utilisateurRepository.findByMatricule(matricule);
        if (existingUser != null) {
            existingUser.setMatricule(utilisateur.getMatricule());
            existingUser.setNom(utilisateur.getNom());
            existingUser.setPrenom(utilisateur.getPrenom());
            existingUser.setAdresseMail(utilisateur.getAdresseMail());
            existingUser.setAdressePostal(utilisateur.getAdressePostal());
            existingUser.setCodePostal(utilisateur.getCodePostal());
            existingUser.setVille(utilisateur.getVille());
            existingUser.setMotDePasse(utilisateur.getMotDePasse());
            existingUser.setStatut(utilisateur.getStatut());
            existingUser.setRole(utilisateur.getRole());
            existingUser.setFormation(utilisateur.getFormation());
            utilisateurRepository.save(existingUser);
        }
    }

    // Supprime un utilisateur
    @DeleteMapping("/delete/{matricule}")
    public void delete(@PathVariable String matricule) {
        Utilisateur user = utilisateurRepository.findByMatricule(matricule);
        if (user != null) {
            utilisateurRepository.delete(user);
        }
    }

    // Désactive un utilisateur
    @PutMapping("/disable/{matricule}")
    public void disable(@PathVariable String matricule) {
        Utilisateur user = utilisateurRepository.findByMatricule(matricule);
        if (user != null) {
            user.setStatut(false);
            utilisateurRepository.save(user);
        }
    }
}
