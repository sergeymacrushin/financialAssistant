package finanassis.service;

import finanassis.model.Cost;

import java.util.List;

public interface CostService {
    List<Cost> allCosts(int id);
    void add(Cost cost);
    void delete(Cost cost);
    void edit(Cost cost);
    Cost getById(int id);
}
