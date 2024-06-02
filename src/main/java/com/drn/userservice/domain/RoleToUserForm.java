package com.drn.userservice.domain;

import lombok.Data;

@Data
public class RoleToUserForm {
    private String username;
    private RoleName roleName;
}
