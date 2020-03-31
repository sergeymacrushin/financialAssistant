package finanassis.service;


import finanassis.dao.CostDAO;
import finanassis.model.Cost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CostServiceImpl implements CostService {
    private CostDAO costDAO;

    @Autowired
    public void setCostDAO(CostDAO costDAO) {
        this.costDAO = costDAO;
    }

    @Transactional
    public List<Cost> allCosts(int id) {
        return costDAO.allCosts(id);
    }

    @Transactional
    public void delete(Cost cost) {
        costDAO.delete(cost);
    }

    @Transactional
    public void edit(Cost cost) {
        costDAO.edit(cost);
    }

    @Transactional
    public Cost getById(int id) {
        return costDAO.getById(id);
    }

    @Transactional
    public void add(Cost cost) {
        costDAO.add(cost);
    }

}
