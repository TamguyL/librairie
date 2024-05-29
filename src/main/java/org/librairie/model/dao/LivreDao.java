package org.librairie.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.librairie.HibernateUtil;
import org.librairie.model.entity.Ecrivain;
import org.librairie.model.entity.Livre;

public class LivreDao {
    public void addLivre(int idecr, Livre l) {
        Session session = null;
        Transaction tr = null;
        Ecrivain e = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tr = session.beginTransaction();
            e = session.get(Ecrivain.class,idecr);
            if (e == null) {
                throw new IllegalArgumentException("Ecrivain with ID " + idecr + " not found");
            }
            e.addLivre(l);

            for(Livre li:e.getLivres()) {
                System.out.println("livre:" +li.getTitre());
            }
            session.persist(l);
            tr.commit();
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
}
