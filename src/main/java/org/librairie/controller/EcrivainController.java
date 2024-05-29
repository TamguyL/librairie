package org.librairie.controller;

import org.librairie.model.entity.Ecrivain;
import org.librairie.model.entity.Livre;
import org.librairie.model.service.EcrivainService;
import org.librairie.view.EcrivainView;

import java.util.List;

public class EcrivainController {

    private EcrivainService ecrivainService = new EcrivainService();
    private EcrivainView ecrivainView = new EcrivainView();

    public void afficheEcrivains() {
        List<Ecrivain> ecrivains = ecrivainService.getEcrivains();
        ecrivainView.AfficheEcrivains(ecrivains);
    }

    // Utiliser pour affichage d'écrivain avec id en dur dans le code
//    public void afficheEcrivain(int id){
//        Ecrivain ecrivain = ecrivainService.getEcrivain(id);
//            ecrivainView.AfficheEcrivain(ecrivain);
//    }
    public void afficheEcrivain(){
        Ecrivain ecrivain = ecrivainService.getEcrivain(ecrivainView.saisieId());
        ecrivainView.AfficheEcrivain(ecrivain);
    }

    // Utiliser pour cree un écrivain en dur dans le code
//    public void create(Ecrivain e) {
//        System.out.println(e.getNom());
//        ecrivainService.create(e) ;
//    }

    public Ecrivain createEcrivain() {
        ecrivainService.createEcrivain(ecrivainView.saisieEcrivain());
        return null;
    }

    public void modifNom(int id, String nouveauNom) {
        ecrivainService.modifNom(id,nouveauNom);
    }
}
