package ovchip;
//reiziger interface overgenomen van het erd

import java.util.List;

public interface ReizigerDAO {
    boolean save(Reiziger reiziger);
    boolean update(Reiziger reiziger);
    boolean delete(Reiziger reiziger);
    Reiziger findById(int id);
    List<Reiziger> findByGbDatum(String datum);
    List<Reiziger> findAll();
}
