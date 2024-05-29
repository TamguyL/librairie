package org.librairie.view;

import org.librairie.model.entity.Ecrivain;
import org.librairie.model.entity.Livre;

import java.util.List;
import java.util.Scanner;

public class EcrivainView {
    public void AfficheEcrivains(List<Ecrivain> ecrivains) {

        for(Ecrivain ecrivain: ecrivains) {
            System.out.println("\n____________________ Ecrivain N° "+ecrivain.getId()+" ____________________");
            System.out.println(ecrivain.getNom()+" "+ecrivain.getPrenom());
            for(Livre l: ecrivain.getLivres()) {
                System.out.println(l.getTitre());
            }
        System.out.println("_______________________________________________________\n");
        }
    }

    public void AfficheEcrivain(Ecrivain ecrivain) {

        System.out.println(ecrivain.getNom()+" "+ecrivain.getPrenom());
        for(Livre l: ecrivain.getLivres()) {
            System.out.println(l.getTitre());
        }

    }

    public int saisieId() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Id écrivain : ");
        int id = scan.nextInt();
        return id;
    }

    public Ecrivain saisieEcrivain() {
        Scanner scannom = new Scanner(System.in);
        System.out.println("Nom écrivain : ");
        String nom = scannom.next();
        Scanner scanprenom = new Scanner(System.in);
        System.out.println("Prénom écrivain : ");
        String prenom = scanprenom.next();
        Ecrivain ecrivain = new Ecrivain(nom, prenom);
        return ecrivain;
    }
}

