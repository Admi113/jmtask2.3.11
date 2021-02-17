package web.dao;

import com.mysql.cj.xdevapi.SessionFactory;
import web.models.User;


import java.util.List;

public interface UserDAO {



    User getUserByName(String name);

    void delete(int id);

    User getById(int id);

    List<User> getAllUsers();


    void save(User user);


    void update(User user, int id);


}
