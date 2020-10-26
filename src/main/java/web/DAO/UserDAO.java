package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {
    void createUser(User user);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long id);
    User getUserByName(String name);
    User getUserById(Long id);
}
