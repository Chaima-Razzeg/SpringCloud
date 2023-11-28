package com.chaima.users.service;

import java.util.List;

import com.chaima.users.entities.Role;
import com.chaima.users.entities.User;

public interface UserService {
User saveUser(User user);
User findUserByUsername (String username);
Role addRole(Role role);
    User addRoleToUser(long id, Role r);
List<User> findAllUsers();

    List<Role> findAllRoles();

    Role findRoleById(Long id);

    void deleteUser(long id);

    User removeRoleFromUser(long id, Role r);

    User findUserById(Long id);

    User activateUser(String username, String code);
}