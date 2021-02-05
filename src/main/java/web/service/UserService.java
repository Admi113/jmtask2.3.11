package web.service;

import web.model.User;

public interface UserService {

    void delete(User user);
    void add(User user);
    void edit(User user);
    User getById(int id);

}
