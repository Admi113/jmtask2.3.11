package web.dao;

import web.model.User;

public interface UserDAO {
    void delete(User user);
    void add(User user);
    void edit(User user);
    User getById(int id);

}
