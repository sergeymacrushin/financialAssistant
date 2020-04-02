package finanassis.dao;

import finanassis.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();
    void delete(User user);
    void add(User user);
    void edit(User user);
    User getById(int id);

}
