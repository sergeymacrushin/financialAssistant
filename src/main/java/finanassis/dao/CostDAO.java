package finanassis.dao;

import finanassis.model.Cost;

import java.util.List;

public interface CostDAO {
    List<Cost> allCosts(int id);
    void delete(Cost cost);
    void add(Cost cost);
    void edit(Cost cost);
    Cost getById(int id);
}
