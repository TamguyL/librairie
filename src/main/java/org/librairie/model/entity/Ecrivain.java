package org.librairie.model.entity;

import javax.persistence.*;
import java.util.List;

@NamedQuery(query = "from Ecrivain where nom=:nom", name="by_nom")
@Entity
//@Table(name = "Ecrivain", uniqueConstraints = {@UniqueConstraint(columnNames = {"nom", "prenom"})})
public class Ecrivain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // @Column(unique = true)
    private String nom;
    private String prenom;

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
            name = "ecrivain_livre",
            joinColumns = { @JoinColumn(name = "id_ecrivain")},
            inverseJoinColumns = { @JoinColumn(name = "id_livre")}
    )
    private List<Livre> livres;

    public Ecrivain(){}
    public Ecrivain(String nom,String prenom) {
        this.nom = nom ;
        this.prenom = prenom ;
    }

    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public List<Livre> getLivres() {
        return this.livres;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void addLivre(Livre livre) {
        this.livres.add(livre);
        livre.setEcrivain(this);
    }
}
