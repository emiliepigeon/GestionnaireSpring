// src/main/java/com/emi/GestionnaireFormation/repository/RoleRepository.java

package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emi.GestionnaireFormation.model.Role;

// Ce repository permet de faire des opérations CRUD sur la table "role"
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Ici je peux ajouter des méthodes personnalisées si besoin, par exemple :
    Role findByLibelle(String libelle);
}
