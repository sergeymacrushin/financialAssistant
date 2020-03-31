package finanassis.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import finanassis.model.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
   @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Cost where id_user="+user.getId()).
                executeUpdate();
        session.createQuery("delete from Revenue where id_user="+user.getId()).
                executeUpdate();
        session.createQuery("delete from User where id="+user.getId()).
                executeUpdate();
    }

    @Override
    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public int getBalance(User user)
    {
        Session session = sessionFactory.getCurrentSession();
        int revenue=(int)session.createQuery("select sum(sum) from Revenue where id_user="+user.
                getId()).list().get(0);
        int cost=(int)session.createQuery("select sum(sum) from Cost where id_user="+user.
                getId()).list().get(0);
        return (revenue-cost);

    }
}
