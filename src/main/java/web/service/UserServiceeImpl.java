package web.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceeImpl implements UserServicee, UserDetailsService {


    private UserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceeImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }


    @Override
    public void save(User user) {
        userDAO.save(user);
    }


    @Override
    public void update(User user, int id) {

        User userOld = getById(id);
        String oldPass = userOld.getPassword();
        String newPass = user.getPassword();
        if (!passwordEncoder.matches(newPass, oldPass)) {
            userOld.setPassword(passwordEncoder.encode(newPass));
        }

        userDAO.update(user, id);
    }


    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }


    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = getUserByName(name);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", name));
        }
        return user;
    }


}
