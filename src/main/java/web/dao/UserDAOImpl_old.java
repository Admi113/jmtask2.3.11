//package web.dao;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import web.models.User;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import java.util.List;
//
//@Repository
//public class UserDAOImpl_old implements UserDAO {
//
////    @Autowired
////    private LocalSessionFactoryBean localSessionFactoryBean;
////    private SessionFactory sessionFactory = (SessionFactory) localSessionFactoryBean.getObject();
//
//    @Autowired
//    private EntityManagerFactory managerFactory;
//
//    private static List<User> users;
//
////    static {
////        users = new ArrayList<>();
////        users.add(new User("name", "surname", 1,1));
////        users.add(new User("name", "surname", 3,2));
////        users.add(new User("name", "surname", 4,3));
////        users.add(new User("name", "surname", 5,4));
////    }
//
//    @Override
//    public void delete(User user) {
//        users.remove(user);
//    }
//
//    @Override
//    public void save(User user) {
//        EntityManager entityManager = managerFactory.createEntityManager();
//        entityManager.getTransaction();
//                entityManager.
//        users.add(user);
//    }
//
//    @Override
//    public void update(User user,int id) {
//        User userToUpdate = getById(id);
//        userToUpdate.setAge(user.getAge());
//        userToUpdate.setId(user.getId());
//        userToUpdate.setName(user.getName());
//        userToUpdate.setSurname(user.getSurname());
//    }
//
//    @Override
//    public User getById(int id) {
//
//        return users.stream().filter(user->user.getId()==id).findAny().orElse(null);
//    }
//
//    @Override
//    public List<User> index() {
////        Session session = (Session) sessionFactory.getSession();
//
////        Query<User> query = session.createQuery("from User ");
////        List<User> allUsers = query.getResultList();
////        return allUsers;
//        return null;
//    }
//
//
//}
