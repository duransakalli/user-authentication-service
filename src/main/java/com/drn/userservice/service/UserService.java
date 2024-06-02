package com.drn.userservice.service;

import com.drn.userservice.domain.Role;
import com.drn.userservice.domain.RoleName;
import com.drn.userservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, RoleName roleName);
    User getUser(String username);
    List<User> getUsers();
}
