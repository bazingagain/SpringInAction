package com.leon.learncache.service.impl;

import com.leon.learncache.bean.Role;
import com.leon.learncache.dao.RoleDao;
import com.leon.learncache.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 13/03/2018.
 *
 * @author Xiaolei-Peng
 */

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    public Role findOne(long id) {
        return roleDao.findOne(id);
    }

    public Role save(Role role) {
        return roleDao.save(role);
    }

    public void remove(long id) {
        roleDao.remove(id);
    }
}
