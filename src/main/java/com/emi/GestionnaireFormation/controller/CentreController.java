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

import com.emi.GestionnaireFormation.model.Centre;
import com.emi.GestionnaireFormation.service.CentreService;

/**
 * Contrôleur REST pour l'entité Centre.
 */
@RestController
@RequestMapping("/centres") // Toutes les routes commencent par /centres
public class CentreController {

    private final CentreService centreService;

    // Injection du service via le constructeur
    public CentreController(CentreService centreService) {
        this.centreService = centreService;
    }

    // GET /centres ou /centres/
    @GetMapping({"", "/"})
    public List<Centre> getAllCentres() {
        return centreService.getAllCentres();
    }

    // GET /centres/{id}
    @GetMapping("/{id}")
    public Optional<Centre> getCentreById(@PathVariable Long id) {
        return centreService.getCentreById(id);
    }

    // POST /centres/create
    @PostMapping("/create")
    public Centre createCentre(@RequestBody Centre centre) {
        return centreService.createCentre(centre);
    }

    // PUT /centres/update/{id} et /centres/{id}
    @PutMapping({"/update/{id}", "/{id}"})
    public Optional<Centre> updateCentre(@PathVariable Long id, @RequestBody Centre details) {
        return centreService.updateCentre(id, details);
    }

    // DELETE /centres/delete/{id}
    @DeleteMapping("/delete/{id}")
    public void deleteCentre(@PathVariable Long id) {
        centreService.deleteCentre(id);
    }

    // PUT /centres/disable/{id} : désactiver un centre (statut à false)
    @PutMapping("/disable/{id}")
    public Optional<Centre> disableCentre(@PathVariable Long id) {
        Optional<Centre> optionalCentre = centreService.getCentreById(id);
        if (optionalCentre.isPresent()) {
            Centre centre = optionalCentre.get();
            centre.setStatut(false); // On met le statut à false pour désactiver le centre
            return Optional.of(centreService.createCentre(centre)); // On sauvegarde la modification
        } else {
            return Optional.empty(); // Centre non trouvé
        }
    }
}
