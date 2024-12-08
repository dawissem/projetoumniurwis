package com.sesame.projetnourouma.controler;

import com.sesame.projetnourouma.entities.Personne;
import com.sesame.projetnourouma.service.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personne")
public class PersonneController {
    @Autowired
    private IPersonneService personneService;
    @GetMapping("/getAll")
    public List<Personne> getAllPersonnes() {
        return personneService.retrieveAllPersonnes();
    }

    @GetMapping("/get/{id}")
    public Personne getPersonneById(@PathVariable int id) {
        return personneService.retrievePersonne(id);
    }

    @PostMapping("/add")
    public Personne addPersonne(@RequestBody Personne personne) {
        return personneService.addPersonne(personne);
    }

    @PutMapping("/update")
    public Personne updatePersonne(@RequestBody Personne personne) {
        return personneService.updatePersonne(personne);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersonne(@PathVariable int id) {
        personneService.deletePersonne(id);
    }
}

