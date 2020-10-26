package web.DAO;

import web.model.Role;

import java.util.Set;

public interface RoleDAO {
    void createRole(Set<Role> roles);
    Set<Role> getAllRoles();
}
