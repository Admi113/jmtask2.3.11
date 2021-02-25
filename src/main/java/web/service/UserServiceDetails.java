package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service

public class UserServiceDetails implements UserDetailsService {

//    private UserServicee userServicee;
//
//    @Autowired
//    public UserServiceDetails(UserServicee userServicee) {
//        this.userServicee = userServicee;
//    }

    @PersistenceContext
    private EntityManager em;

    public User getUserByName(String name) {
//        Query q = em.createQuery("from User where name =: name", User.class);
        Query q = em.createQuery("from User where name =: name");
        q.setParameter("name", name);
        return (User) q.getSingleResult();
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
