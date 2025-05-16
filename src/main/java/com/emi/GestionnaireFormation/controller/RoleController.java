// src/main/java/com/emi/GestionnaireFormation/controller/RoleController.java

package com.emi.GestionnaireFormation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emi.GestionnaireFormation.model.Role;
import com.emi.GestionnaireFormation.repository.RoleRepository;

// Ce contrôleur gère les requêtes HTTP pour l'entité Role
@RestController
@RequestMapping("/roles") // L'URL de base pour les rôles
public class RoleController {

    private final RoleRepository roleRepository;

    // J'injecte le repository dans le contrôleur
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // GET /roles : récupérer tous les rôles
    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // GET /roles/{id} : récupérer un rôle par son id
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        Optional<Role> role = roleRepository.findById(id);
        // Si le rôle existe, on le retourne, sinon on retourne null (ou tu peux gérer une erreur)
        return role.orElse(null);
    }

    // POST /roles/create : créer un nouveau rôle
    @PostMapping("/create")
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    // PUT /roles/update/{id} : modifier un rôle existant
    @PutMapping("/update/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody Role roleDetails) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            role.setLibelle(roleDetails.getLibelle());
            role.setStatut(roleDetails.getStatut());
            return roleRepository.save(role);
        } else {
            return null; // Ou tu peux gérer l'erreur autrement
        }
    }

    // DELETE /roles/delete/{id} : supprimer un rôle
    @DeleteMapping("/delete/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);
    }

    // PUT /roles/disable/{id} : désactiver un rôle (mettre statut à false)
    @PutMapping("/disable/{id}")
    public Role disableRole(@PathVariable Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            role.setStatut(false); // On met le statut à false pour désactiver le rôle
            return roleRepository.save(role);
        } else {
            return null; // Ou tu peux gérer l'erreur autrement
        }
    }
}
