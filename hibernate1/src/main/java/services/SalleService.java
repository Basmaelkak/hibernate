package services;

import entities.Salle;
import util.HibernateUtil;
import java.dao.IDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import java.util.List;

public class SalleService implements IDao<Salle>{
    public boolean create(Salle o) {
        Session session = null;
    Transaction tx = null;
    boolean etat = false;
    try {
        session =HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.save(o);
        tx.commit();
        etat = true;
    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null)
            session.close();
    }
    return etat;
}
@Override
public boolean delete (Salle o) {
    Session session= null;
    Transaction tx = null;
    boolean etat = false;
    try {
        session= HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.delete(o);
        tx.commit();
        etat =true;
    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null)
            session.close();
    }
    return etat;
}
@Override
public boolean update (Salle o) {
    Session session = null;
    Transaction tx = null;
    boolean etat = false;
    try {
        session =HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.update(o);
        tx.commit();
        etat =true;
    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null)
            session.close();
    }
    return etat;
}
    @Override
    public Salle findById(int id) {
        Session session= null;
        Transaction tx = null;
        Salle salle = null;
        try {
            session =HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salle =session.get(Salle.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return salle;
    }
    @Override
    public List<Salle> findAll() {
        Session session= null;
        Transaction tx = null;
        List<Salle> salles= null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            salles = session.createQuery("from Salle", Salle.class).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return salles;
    }

        }


