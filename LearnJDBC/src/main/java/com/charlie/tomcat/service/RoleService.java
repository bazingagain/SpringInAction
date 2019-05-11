package com.charlie.tomcat.service;

import com.charlie.tomcat.dao.RoleRepository;
import com.charlie.tomcat.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public void addRole(Role role) {
        roleRepository.addRole(role);
    }

    public Role findRole(Long id) {
        return roleRepository.findOne(id);
    }
}
