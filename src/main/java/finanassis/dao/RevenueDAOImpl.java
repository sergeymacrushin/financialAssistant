package finanassis.dao;

import finanassis.model.Revenue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RevenueDAOImpl implements RevenueDAO{
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Revenue> allRevenues(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Revenue where id_user="+id).list();
    }

    @Override
    public void add(Revenue revenue) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(revenue);
    }

    @Override
    public void delete(Revenue revenue) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(revenue);
    }

    @Override
    public void edit(Revenue revenue) {
        Session session = sessionFactory.getCurrentSession();
        session.update(revenue);
    }

    @Override
    public Revenue getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Revenue.class, id);
    }

}
