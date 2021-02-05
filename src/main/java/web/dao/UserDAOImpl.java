package web.dao;

import web.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User("name", "surname", 1));
        users.add(new User("name", "surname", 3));
        users.add(new User("name", "surname", 4));
        users.add(new User("name", "surname", 5));
        users.add(new User("name", "surname", 6));
        users.add(new User("name", "surname", 7));
        users.add(new User("name", "surname", 8));
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void edit(User user) {

    }

    @Override
    public User getById(int id) {
        return null;
    }
}
