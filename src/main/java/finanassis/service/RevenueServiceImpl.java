package finanassis.service;

import finanassis.dao.RevenueDAO;
import finanassis.model.Revenue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RevenueServiceImpl implements RevenueService{

    private RevenueDAO revenueDAO;

    @Autowired
    public void setRevenueDAO(RevenueDAO revenueDAO) {
        this.revenueDAO = revenueDAO;
    }

    @Transactional
    public List<Revenue> allRevenues(int id) {
        return revenueDAO.allRevenues(id);
    }

    @Transactional
    public void delete(Revenue revenue) {
        revenueDAO.delete(revenue);
    }

    @Transactional
    public void edit(Revenue revenue) {
        revenueDAO.edit(revenue);
    }

    @Transactional
    public Revenue getById(int id) {
        return revenueDAO.getById(id);
    }

    @Transactional
    public void add(Revenue revenue) {
        revenueDAO.add(revenue);
    }
}
