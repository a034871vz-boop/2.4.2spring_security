package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.RoleDAO;
import web.DAO.UserDAO;
import web.model.Role;
import web.model.User;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDao;
    private RoleDAO roleDao;

    public UserServiceImpl() {}

    @Autowired
    public UserServiceImpl(UserDAO userDao, RoleDAO roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Transactional
    @PostConstruct
    public void init(){
        Role[] roles = {new Role("ROLE_ADMIN"), new Role("ROLE_USER")};
        Set<Role> allRoles = new HashSet<>(Arrays.asList(roles));
        roleDao.createRole(allRoles);
        User admin = new User("admin","admin","10","admin", "admin");
        admin.setRoles(allRoles);
        userDao.createUser(admin);
    }

    // Create
    @Transactional
    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    // Read
    @Transactional
    @Override
    public User getUserById(Long id) {
        return (User) userDao.getUserById(id);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    // Update
    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    // Delete
    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Transactional
    @Override
    public void createRole(Set<Role> roles) {
        roleDao.createRole(roles);
    }

    @Transactional
    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}
