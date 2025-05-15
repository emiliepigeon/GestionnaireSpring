// src/main/java/com/emi/GestionnaireFormation/repository/RoleRepository.java

package com.emi.GestionnaireFormation.repository;

import com.emi.GestionnaireFormation.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Ce repository permet de faire des opérations CRUD sur la table "role"
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Ici tu peux ajouter des méthodes personnalisées si besoin, par exemple :
    Role findByLibelle(String libelle);
}
