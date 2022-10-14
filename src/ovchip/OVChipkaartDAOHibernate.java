package ovchip;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OVChipkaartDAOHibernate implements OVChipkaartDAO {
    private Session session;

    public OVChipkaartDAOHibernate(Session session) {
        this.session = session;
    }
    //sla op ovchipkaart
    @Override
    public boolean save(OVChipkaart ovChipkaart) {
        try {
            Transaction transaction = this.session.beginTransaction();
            session.save(ovChipkaart);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //update ovchipkaart
    @Override
    public boolean update(OVChipkaart ovChipkaart) {
        try {
            Transaction transaction = this.session.beginTransaction();
            session.save(ovChipkaart);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //verwijder ovchipkaart
    @Override
    public boolean delete(OVChipkaart ovChipkaart) {
        try {
            Transaction transaction = this.session.beginTransaction();
            session.delete(ovChipkaart);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    @Override
    public List<OVChipkaart> findByReiziger(Reiziger reiziger) {
        try {
            Transaction transaction = this.session.beginTransaction();
            List<OVChipkaart> ovChipkaarten = session.createQuery("FROM OVChipkaart WHERE reiziger_id = " + reiziger.getReiziger_id(), OVChipkaart.class).getResultList();
            transaction.commit();
            return ovChipkaarten;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}