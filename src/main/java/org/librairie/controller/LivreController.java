package org.librairie.controller;

import org.librairie.model.entity.Livre;
import org.librairie.model.service.EcrivainService;
import org.librairie.model.service.LivreService;
import org.librairie.view.LivreView;

import java.util.List;
public class LivreController {

    private LivreService livreService = new LivreService();

    public void addLivre(int id, Livre l){
        livreService.addLivre(id, l);
    }
}
