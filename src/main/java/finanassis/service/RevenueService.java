package finanassis.service;

import finanassis.model.Revenue;

import java.util.List;

public interface RevenueService {
    List<Revenue> allRevenues(int id);
    void add(Revenue revenue);
    void delete(Revenue revenue);
    void edit(Revenue revenue);
    Revenue getById(int id);
}
