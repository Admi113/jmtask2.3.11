package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO = new UserDAOImpl();
//    @Autowired
//    public void setUserDAO(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    @Override
    public void update(User user, int id) {
        User userToChange = userDAO.getById(id);
        userToChange.setAge(user.getAge());
        userToChange.setName(user.getName());
        userToChange.setSurname(user.getSurname());
    }

    @Transactional
    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
