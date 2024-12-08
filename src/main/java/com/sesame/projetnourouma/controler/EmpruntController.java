package com.sesame.projetnourouma.controler;

import com.sesame.projetnourouma.entities.Emprunt;
import com.sesame.projetnourouma.service.IEmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprunt")
public class EmpruntController {
    @Autowired
    private IEmpruntService empruntService;
    @GetMapping("/getAll")
    public List<Emprunt> getAllEmprunts() {
        return empruntService.retrieveAllEmprunts();
    }

    @GetMapping("/get/{id}")
    public Emprunt getEmprunt(@PathVariable int id) {
        return empruntService.retrieveEmprunt(id);
    }

    @PostMapping("/add")
    public Emprunt addEmprunt(@RequestBody Emprunt emprunt) {
        return empruntService.createEmprunt(emprunt);
    }

    @PutMapping("/update")
    public Emprunt updateEmprunt(@RequestBody Emprunt emprunt) {
        return empruntService.updateEmprunt(emprunt);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmprunt(@PathVariable int id) {
        empruntService.deleteEmprunt(id);
    }
}


