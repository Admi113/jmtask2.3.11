package web.dao;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User u) {
        em.persist(u);
    }

    @Override
    public void update(User user, int id) {
       User user1 = getById(id);
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        user1.setAge(user.getAge());
        Session session =em.unwrap(Session.class);
        session.saveOrUpdate(user1);
    }


    @Override
    public void delete(int id) {
        User user = getById(id);
        em.remove(user);
    }

    @Override
    public User getById(int id) {
        return  em.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        Query q = em.createQuery("from User e", User.class);
        return q.getResultList();
    }


}







