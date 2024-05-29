package org.librairie.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Livre", uniqueConstraints = {@UniqueConstraint(columnNames = {"titre"})})
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Titre ;

    @ManyToMany(mappedBy = "livres")
    private List<Ecrivain> ecrivains;

    public Livre() {}
    public Livre(String titre) {
        Titre = titre;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public List<Ecrivain> getEcrivains() {
        return ecrivains;
    }

    public void setEcrivains(List<Ecrivain> ecrivains) {
        this.ecrivains = ecrivains;
    }

    public void setEcrivain(Ecrivain ecrivain) {
    }
}
