package web.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    SessionFactory sessionFactory;
//    EntityManager em;


    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

//    @Override
//    public void update(User user, int id) {
//        user = getById(id);
//        edit(user);
//    }

//    @Override
//    public void edit(User u) {
//        em.merge(u);
//
//    }

    @Override
    public void delete(int id) {
//        em.remove(user);

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from" +
                " User where id= :id");
        query.setParameter("id",id);
        query.executeUpdate();
    }

    @Override
    public User getById(int id) {
        Session session= sessionFactory.getCurrentSession();
        User user = session.get(User.class,id);
        return user;
    }

    @Override
    public List<User> getAllUsers() {

        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

}







