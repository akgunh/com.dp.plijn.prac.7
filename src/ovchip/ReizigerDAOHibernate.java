package ovchip;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReizigerDAOHibernate implements ReizigerDAO {
    private final Session session;

    public ReizigerDAOHibernate(Session session) {
        this.session = session;
    }
    //sla op reiziger
    @Override
    public boolean save(Reiziger reiziger) {
        Transaction transaction = this.session.beginTransaction();
        try {
            session.save(reiziger);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return true;
    }
    //update reiziger
    @Override
    public boolean update(Reiziger reiziger) {
        try {
            Transaction transaction = this.session.beginTransaction();
            session.update(reiziger);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //verwijder reiziger
    @Override
    public boolean delete(Reiziger reiziger) {
        try {
            Transaction transaction = this.session.beginTransaction();
            session.delete(reiziger);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //vind reiziger bijID
    @Override
    public Reiziger findById(int id) {
        try {
            Transaction transaction = this.session.beginTransaction();
            Reiziger reiziger = session.createQuery(" FROM Reiziger where reiziger_id = " + id, Reiziger.class).getSingleResult();
            transaction.commit();
            return reiziger;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    //vind reiziger bij geboortedatum
    @Override
    public List<Reiziger> findByGbDatum(String datum) {
        try {
            Transaction transaction = this.session.beginTransaction();
            List<Reiziger> reizigers = session.createQuery("FROM Reiziger WHERE geboortedatum = " + datum, Reiziger.class).getResultList();
            transaction.commit();
            return reizigers;
        } catch (Exception e) {
            return null;
        }
    }
    //vind reiziger
    @Override
    public List<Reiziger> findAll() {
        try {
            Transaction transaction = this.session.beginTransaction();
            List<Reiziger> reizigers = session.createQuery("from Reiziger", Reiziger.class).getResultList();
            transaction.commit();
            return reizigers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}