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
import com.emi.GestionnaireFormation.repository.UtilisateurRepository;

/**
 * Contrôleur REST pour l'entité Utilisateur.
 * Toutes les méthodes renvoient du JSON.
 */
@RestController
@RequestMapping("/utilisateurs") // Toutes les routes commencent par /utilisateurs
public class UtilisateurController {

    private final UtilisateurRepository utilisateurRepository;

    // Injection du repository via le constructeur
    public UtilisateurController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // GET /utilisateurs ou /utilisateurs/
    @GetMapping({"", "/"})
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // GET /utilisateurs/{matricule}
    @GetMapping("/{matricule}")
    public Utilisateur getUtilisateurByMatricule(@PathVariable String matricule) {
        return utilisateurRepository.findByMatricule(matricule);
    }

    // POST /utilisateurs/create
    @PostMapping("/create")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // PUT /utilisateurs/update/{matricule}
    @PutMapping("/update/{matricule}")
    public Utilisateur updateUtilisateur(@PathVariable String matricule, @RequestBody Utilisateur details) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        if (utilisateur != null) {
            utilisateur.setNom(details.getNom());
            utilisateur.setPrenom(details.getPrenom());
            utilisateur.setAdresseMail(details.getAdresseMail());
            utilisateur.setAdressePostal(details.getAdressePostal());
            utilisateur.setCodePostal(details.getCodePostal());
            utilisateur.setVille(details.getVille());
            utilisateur.setMotDePasse(details.getMotDePasse());
            utilisateur.setStatut(details.getStatut());
            utilisateur.setRole(details.getRole());
            return utilisateurRepository.save(utilisateur);
        }
        return null;
    }

    // DELETE /utilisateurs/delete/{matricule}
    @DeleteMapping("/delete/{matricule}")
    public void deleteUtilisateur(@PathVariable String matricule) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        if (utilisateur != null) {
            utilisateurRepository.delete(utilisateur);
        }
    }

    // PUT /utilisateurs/disable/{matricule}
    @PutMapping("/disable/{matricule}")
    public Utilisateur disableUtilisateur(@PathVariable String matricule) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        if (utilisateur != null) {
            utilisateur.setStatut(false);
            return utilisateurRepository.save(utilisateur);
        }
        return null;
    }
}
