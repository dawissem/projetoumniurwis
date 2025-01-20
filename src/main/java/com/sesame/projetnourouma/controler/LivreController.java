package com.sesame.projetnourouma.controler;

import com.sesame.projetnourouma.entities.Livre;
import com.sesame.projetnourouma.service.ILivreService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

@RestController
@RequestMapping("/api/livre")
public class LivreController {

    @Autowired
    private ILivreService livreService;

    @GetMapping("/getAll")
    public List<Livre> getAllLivres() {
        return livreService.retrieveAllLivres();

    }

    @GetMapping("/get/{id}")
    public Livre getLivreById(@PathVariable int id) {
        return livreService.retrieveLivreById(id);
    }

    @PostMapping("/add")
    public Livre addLivre(@RequestBody Livre livre) {
        return livreService.addLivre(livre);
    }


    @PutMapping("/update/{id}")
    public Livre updateLivre(@PathVariable int id, @RequestBody Livre livre) {
        livre.setId(id); // Ensure the ID is set in the entity
        return livreService.updateLivre(livre);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLivre(@PathVariable int id) {
        livreService.deleteLivreById(id);
    }


    @GetMapping("/search/title")
    public List<Livre> searchByTitle(@RequestParam String titre) {
        return livreService.findByTitre(titre);
    }
    @GetMapping("/search/isbn")
    public List<Livre> searchByIsbn(@RequestParam String isbn) {
        return livreService.findByIsbn(isbn);
    }


    @GetMapping("/search/category")
    public List<Livre> searchByCategory(@RequestParam Category categorie) {
        return livreService.findByCategorie(categorie);
    }




}
