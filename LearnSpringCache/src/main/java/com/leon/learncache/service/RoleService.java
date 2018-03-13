package com.leon.learncache.service;

import com.leon.learncache.bean.Role;

/**
 * Created on 13/03/2018.
 *
 * @author Xiaolei-Peng
 */
public interface RoleService {
    Role findOne(long id);
    Role save(Role role);
    void remove(long id);
}
