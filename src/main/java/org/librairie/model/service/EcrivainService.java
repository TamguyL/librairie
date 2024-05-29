package org.librairie.model.service;

import org.hibernate.Session;
import org.librairie.model.dao.EcrivainDao;
import org.librairie.model.entity.Ecrivain;


import java.util.List;

public class EcrivainService {
   // partie service
    private EcrivainDao ecrivainDao = new EcrivainDao();

    public List getEcrivains() {
        List ecrivains = ecrivainDao.getEcrivains() ;
        return ecrivains ;
    }

    public Ecrivain getEcrivain(int id){
        Ecrivain ecrivain = ecrivainDao.getEcrivain(id) ;
        return (ecrivain);
    }

    // Utiliser pour cree un écrivain en dur dans le code
//    public void create(Ecrivain e) {
//        ecrivainDao.create(e);
//    }

    public void createEcrivain(Ecrivain e) {
        ecrivainDao.createEcrivain(e);
    }

    public void modifNom(int id, String nom ) {
        ecrivainDao.modifNom(id, nom );
    }
}
