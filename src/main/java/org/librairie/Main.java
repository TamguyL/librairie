package org.librairie;

import org.librairie.controller.EcrivainController;
import org.librairie.controller.LivreController;
import org.librairie.model.dao.EcrivainDao;
import org.librairie.model.entity.Ecrivain;
import org.librairie.model.entity.Livre;
import org.librairie.view.EcrivainView;

public class Main {
    public static void main(String[] args) {
//        EcrivainController ec = new EcrivainController();
        // Affiche une liste d'ecrivains
        // ec.afficheEcrivains();

        // Affiche un ecrivain select par id
        // ec.afficheEcrivain(5);

        // Crée un nouvel ecrivain
        // ec.create(new Ecrivain("Bettero","Pierre"));
        // ec.create(new Ecrivain("Smith","Jacke"));

        // Modifie le nom d'un ecrivain
        // ec.modifNom(5,"Bottero");
        // ec.afficheEcrivain(5);

        // Test de saisie d'id  par l'utilisateur
//        EcrivainView ev = new EcrivainView();
////        ec.afficheEcrivain();
//        // ec.createEcrivain();
//        ec.afficheEcrivains();



        // Création de Livre avec une association d'ecrivain
//        LivreController lc = new LivreController();
//        Livre l = new Livre("Livrelivre");
//        lc.addLivre(1, l);

        Ecrivain writer = new EcrivainDao().getEcrivainByName("Bottero");
        System.out.println(writer.getNom()+ " " + writer.getPrenom());



    }
}