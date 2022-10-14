package ovchip;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdresDAOHibernate implements AdresDAO {
    private Session session;

    public AdresDAOHibernate(Session session) {
        this.session = session;
    }
    //opslaan adres
    @Override
    public boolean save(Adres adres) {
        try {
            Transaction transaction = this.session.beginTransaction();
            session.save(adres);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //update adres
    @Override
    public boolean update(Adres adres) {
        try {
            Transaction transaction = this.session.beginTransaction();
            session.update(adres);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //verwijder adres
    @Override
    public boolean delete(Adres adres) {
        try {
            Transaction transaction = this.session.beginTransaction();
            session.delete(adres);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //vind bij reiziger
    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        try {
            Transaction transaction = this.session.beginTransaction();
            Adres adres = session.createQuery("FROM Adres WHERE reiziger_id = " + reiziger.getReiziger_id(), Adres.class).getSingleResult();
            transaction.commit();
            return adres;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    //vind all adres
    @Override
    public List<Adres> findAll() {
        try {
            Transaction transaction = this.session.beginTransaction();
            List<Adres> adressen = session.createQuery(" FROM Adres", Adres.class).getResultList();
            List<Adres> adressenList = new ArrayList<>(adressen);
            transaction.commit();
            return adressenList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
