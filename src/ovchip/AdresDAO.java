package ovchip;
//adres interface overgenomen vanuit het erd en de vorige practica

import java.util.List;
public interface AdresDAO {
    boolean save(Adres adres);
    boolean update(Adres adres);
    boolean delete(Adres adres);
    Adres findByReiziger(Reiziger reiziger);
    List<Adres> findAll();
}

