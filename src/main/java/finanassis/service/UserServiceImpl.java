package finanassis.service;

import finanassis.dao.CostDAO;
import finanassis.dao.RevenueDAO;
import finanassis.dao.UserDAO;

import finanassis.model.Cost;
import finanassis.model.Revenue;
import finanassis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;
    private CostDAO costDAO;
    private RevenueDAO revenueDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setCostDAO(CostDAO costDAO) {
        this.costDAO = costDAO;
    }

    @Autowired
    public void setRevenueDAO(RevenueDAO revenueDAO) {
        this.revenueDAO = revenueDAO;
    }

    @Transactional
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Transactional
    public void edit(User user) {
        userDAO.edit(user);
    }

    @Transactional
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Transactional
    public int getBalance(User user)
    {
        int balance=0;
        List<Cost> costList = costDAO.allCosts(user.getId());
        List<Revenue> revenueList = revenueDAO.allRevenues(user.getId());
        for(int i=0;i<costList.size();i++)
        {balance-=costList.get(i).getSum();}
        for(int j=0;j<revenueList.size();j++)
        {balance+=revenueList.get(j).getSum();}
        return balance;
    }

}
