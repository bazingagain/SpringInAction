package com.charlie.tomcat.dao;

import com.charlie.tomcat.entity.Role;

public interface RoleRepository {
    void addRole(Role role);
    Role findOne(Long id);
}
