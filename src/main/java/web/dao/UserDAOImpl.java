package web.dao;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    EntityManagerFactory entityManagerFactory;

    EntityManager em;


    @Override
    public void save(User u) {
        em.persist(u);
    }

    @Override
    public void update(User user, int id) {
        user = getById(id);
        edit(user);
    }

    @Override
    public void edit(User u) {
        em.merge(u);

    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

    @Override
    public User getById(int id) {
        return (User) em.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {

//        String sql = " FROM users_new";
//        Query query = em.createQuery(sql);
//
//
//        return em.createQuery("SELECT * FROM users_new").getResultList();

       List<User> users = new ArrayList<>();
        users.add(new User("name", "surname", 1,1));
        users.add(new User("name", "surname", 3,2));
        users.add(new User("name", "surname", 4,3));
        users.add(new User("name", "surname", 5,4));
       return users;
    }

}







