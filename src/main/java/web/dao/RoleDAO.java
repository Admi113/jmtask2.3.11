package web.dao;

import web.models.Role;
import web.models.User;

import javax.persistence.Query;
import java.util.List;

public interface RoleDAO {
    List<Role> getAllRoles();

    Role getRoleByName(String name);

    Role getById(long id);
}
