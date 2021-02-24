package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Role;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Role> getAllRoles() {
        Query q = em.createQuery("from Role e", Role.class);
        return q.getResultList();
    }
}
