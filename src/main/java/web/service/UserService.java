package web.service;

import web.models.User;

import java.util.List;

public interface UserService {

    void delete(User user);
    void save(User user);
    void update(User user,int id);
    User getById(int id);








    List<User> getAllUsers();







}
