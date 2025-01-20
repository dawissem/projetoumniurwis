package com.sesame.projetnourouma.service;

import com.sesame.projetnourouma.entities.Livre;
import jdk.jfr.Category;

import java.util.List;

public interface ILivreService {
    public List<Livre>retrieveAllLivres();
    public Livre retrieveLivreById(int id);
    public void deleteLivreById(int id);
    public Livre updateLivre(Livre livre);
    public Livre addLivre(Livre livre);


    List<Livre> findByTitre(String titre);
    List<Livre> findByIsbn(String isbn);

    List<Livre> findByCategorie(Category categorie);
}
