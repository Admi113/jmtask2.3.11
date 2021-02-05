package web.service;

import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import web.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {


    UserDAO userDAO = new UserDAOImpl();

    @Override
    public void delete(User user) {
       userDAO.delete(user);
    }

    @Override
    public void add(User user) {
       userDAO.add(user);
    }

    @Override
    public void edit(User user) {
    userDAO.edit(user);
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }
}
