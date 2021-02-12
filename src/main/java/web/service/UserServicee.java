package web.service;

import web.models.User;

import java.util.List;

public interface UserServicee {
    User getUserByName(String name);

    void delete(int id);
    void save(User user);
    void update(User user,int id);
    User getById(int id);
    List<User> getAllUsers();

}
