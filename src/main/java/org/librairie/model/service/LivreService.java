package org.librairie.model.service;

import org.librairie.model.dao.LivreDao;
import org.librairie.model.entity.Livre;

public class LivreService {

    private LivreDao livreDao = new LivreDao();

    public void addLivre(int id, Livre l){
        livreDao.addLivre(id, l);
    }
}
