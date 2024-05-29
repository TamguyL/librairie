package org.librairie.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.librairie.HibernateUtil;
import org.librairie.model.entity.Ecrivain;

import java.util.List;

public class EcrivainDao {

    // echange objet->Databe et Database vers Objet
    public List<Ecrivain> getEcrivains() {
        // je récupère la session Hibernate qui permet de persister les données.
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Ecrivain> query = session.createQuery("from Ecrivain",Ecrivain.class);
        List<Ecrivain> ecrivains = query.getResultList();
        return ecrivains;
    }

    public Ecrivain getEcrivain(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Ecrivain> query = session.createQuery("from Ecrivain where id=:id", Ecrivain.class);
        query.setInteger("id",id);
        Ecrivain ecrivain = query.getSingleResult();
        return ecrivain;
    }

    // Utiliser pour cree un écrivain en dur dans le code
//    public void create(Ecrivain e) {
//        Session session = null;
//        Transaction tr = null;
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            tr = session.beginTransaction();
//            session.persist(e); // passage de l'état Transiant (transitoire) à l'état persist dans la session
//            // session.flush(); // synchronisation de la session avec la BDD.
//            tr.commit(); // le flush déclanche un commit et inversement. laissons hibernate faire avec commit
//            System.out.println("écrivain créé avec l'id:" + e.getId());
//        } catch (Exception ex) {
//            if (tr != null) {
//                tr.rollback();
//            }
//            ex.getMessage();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }

    public void createEcrivain(Ecrivain e) {
        Session session = null;
        Transaction tr = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.persist(e);
            tr.commit();
            System.out.println("écrivain créé avec l'id:" + e.getId());
        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            ex.getMessage();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void modifNom(int id,String nom) {
        Session session = null;
        Transaction tr = null;
        Ecrivain e = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            e = session.get(Ecrivain.class,id);
            e.setNom(nom);
            session.persist(e); // passage de l'état Transiant (transitoire) à l'état persist dans la session
            // session.flush(); // synchronisation de la session avec la BDD.
            tr.commit(); // le flush déclanche un commit et inversement. laissons hibernate faire avec commit
            System.out.println("Nouveau nom de l'écrivain "+id+" :" + e.getNom());
        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            ex.getMessage();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Ecrivain getEcrivainByName(String nom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Ecrivain> query= session.createNamedQuery("by_nom", Ecrivain.class);
        query.setParameter("nom", nom);
        Ecrivain ecrivain = query.getSingleResult();
        return ecrivain;
    }

}

