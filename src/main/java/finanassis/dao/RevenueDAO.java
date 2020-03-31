package finanassis.dao;

import finanassis.model.Revenue;

import java.util.List;

public interface RevenueDAO {
    List<Revenue> allRevenues(int id);
    void delete(Revenue revenue);
    void add(Revenue revenue);
    void edit(Revenue revenue);
    Revenue getById(int id);
}
