package web.dao;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;


    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(User u) {
        em.persist(u);
    }

    @Override
    public void update(User user, int id) {
        User userOld = getById(id);
        userOld.setName(user.getName());
        userOld.setSurname(user.getSurname());
        userOld.setAge(user.getAge());
        userOld.setRoles(user.getRoles());

        String oldPass = userOld.getPassword();
        String newPass = user.getPassword();
//        if (!newPass.equals(oldPass))
        if (!passwordEncoder.matches(newPass, oldPass)) {
            userOld.setPassword(passwordEncoder.encode(newPass));
        }
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(userOld);
    }


    @Override
    public User getUserByName(String name) {
//        Query q = em.createQuery("from User where name =: name", User.class);
        Query q = em.createQuery("from User where name =: name");
        q.setParameter("name", name);
        return (User) q.getSingleResult();
    }

    @Override
    public void delete(int id) {
        User user = getById(id);
        em.remove(user);
    }

    @Override
    public User getById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        Query q = em.createQuery("from User e", User.class);
        return q.getResultList();
    }


}







