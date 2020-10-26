package web.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("select u from User u ")
                .getResultList();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Transactional
    @Override
    public User getUserByName(String name) {
        return (User) entityManager
                .createQuery("select u from User u  where u.email=:name")
                .setParameter("name", name)
                .getSingleResult();
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return (User) entityManager
                .createQuery("select u from User u  where u.id=:id")
                .setParameter("id", id)
                .getSingleResult();
    }
}
