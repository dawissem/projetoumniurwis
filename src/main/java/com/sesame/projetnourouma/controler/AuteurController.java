package com.sesame.projetnourouma.controler;

import com.sesame.projetnourouma.entities.Auteur;
import com.sesame.projetnourouma.service.IAuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auteurs")
public class AuteurController {

    @Autowired
    private IAuteurService auteurService;

    @GetMapping
    public List<Auteur> getAllAuteurs() {
        return auteurService.retrieveAllAuteurs();
    }
    @GetMapping("/{id}")
    public Auteur getAuteurById(@PathVariable int id) {
        return auteurService.retrieveAuteurById(id);
    }

    @PostMapping
    public Auteur createAuteur(@RequestBody Auteur auteur) {
        return auteurService.addAuteur(auteur);
    }

    @PutMapping
    public Auteur updateAuteur(@RequestBody Auteur auteur) {
        return auteurService.updateAuteur(auteur);
    }

    @DeleteMapping("/{id}")
    public void  deleteAuteur(@PathVariable int id) {
        auteurService.deleteAuteur(id);

    }
}