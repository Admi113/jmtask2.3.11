package web.dao;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManagerFactory entityManagerFactory;

    private EntityManager em;

    @Autowired
    public UserDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @PostConstruct
    public void init() {
        em=entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(User u) {
        em.persist(u);
    }

    @Override
    public void update(User user, int id) {
       User user1 = getById(id);

    }

    @Override
    public void edit(User user) {
        em.merge(user);

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







