package com.charlie.tomcat.web;

import com.charlie.tomcat.entity.Role;
import com.charlie.tomcat.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/addRole")
    @ResponseBody
    public void addRole() {
        Role role = new Role("test");
        roleService.addRole(role);
    }

    @RequestMapping("/findRole")
    @ResponseBody
    public Role findRole(Long id){
        return roleService.findRole(id);
    }
}
