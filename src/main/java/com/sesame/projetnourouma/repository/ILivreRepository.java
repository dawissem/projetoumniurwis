package com.sesame.projetnourouma.repository;

import com.sesame.projetnourouma.entities.Livre;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILivreRepository extends JpaRepository<Livre, Integer> {
    List<Livre> findByTitre(String titre);
    List<Livre> findByIsbn(String isbn);
    List<Livre> findByCategorie(Category categorie);

}
