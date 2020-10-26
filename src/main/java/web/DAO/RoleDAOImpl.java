package web.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("roleDao")
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    EntityManager entityManager;

    protected EntityManager getEntityManager(){
        return this.entityManager;
    }

    @Transactional
    @Override
    public void createRole(Set<Role> roles) {
        roles.forEach(role -> entityManager.persist(role));
    }

    @Transactional
    @Override
    public Set<Role> getAllRoles() {
        Set<Role> setRoles = new HashSet<>();
        List<Role> listRoles= entityManager
                .createQuery("select r from Role r")
                .getResultList();
        setRoles.addAll(listRoles);
        return setRoles;
    }
}
