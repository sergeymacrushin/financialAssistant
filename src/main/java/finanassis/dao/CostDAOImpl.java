package finanassis.dao;

import finanassis.model.Cost;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CostDAOImpl implements CostDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Cost> allCosts(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Cost where id_user="+id).list();
    }

    @Override
    public void add(Cost cost) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(cost);
    }

    @Override
    public void delete(Cost cost) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cost);
    }

    @Override
    public void edit(Cost cost) {
        Session session = sessionFactory.getCurrentSession();
        session.update(cost);
    }

    @Override
    public Cost getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Cost.class, id);
    }
}
