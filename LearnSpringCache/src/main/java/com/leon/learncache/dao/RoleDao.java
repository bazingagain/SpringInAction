package com.leon.learncache.dao;


import com.leon.learncache.bean.Role;

/**
 * Created on 13/03/2018.
 *
 * @author Xiaolei-Peng
 */
public interface RoleDao {
    Role findOne(long id);

    Role save(Role role);

    void remove(long id);
}
