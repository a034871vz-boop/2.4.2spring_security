package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void createUser(User user);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long id);
    User getUserByName(String name);
    User getUserById(Long id);
    void createRole(Set<Role> roles);
    Set<Role> getAllRoles();
}
