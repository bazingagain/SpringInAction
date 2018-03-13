package com.leon.learncache.dao.impl;

import com.leon.learncache.bean.Role;
import com.leon.learncache.dao.RoleDao;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;


/**
 * Created on 13/03/2018.
 *
 * @author Xiaolei-Peng
 */
public class RoleDaoImpl implements RoleDao {

    private static List<Role> roles = new ArrayList<Role>();

    static {
        for (int i = 0; i < 10; i++) {
            roles.add(new Role(i, "leon 00" + i));
        }
    }

    @Cacheable("roleCache") // 1. Cacheable方式
//    @CachePut("roleCache") // 2. CachePut方式
//    @Cacheable(value = "roleCache", unless = "#result.name.contains('NoCache')")
//    @Cacheable(value = "roleCache", unless = "#result.name.contains('NoCache')", condition = "#id>10")
    public Role findOne(long id) {
        if (id >= 0 && id < roles.size()) {
            return roles.get((int)id);
        } else {
            return null;
        }
    }


    @Cacheable(value = "roleCache", key = "#result.id")
    public Role save(Role role) {
        role.setId(roles.size()+1);
        roles.add(role);
        return role;
    }

    @CacheEvict("roleCache")
    public void remove(long id) {
        roles.set((int)id, null);
    }
}
