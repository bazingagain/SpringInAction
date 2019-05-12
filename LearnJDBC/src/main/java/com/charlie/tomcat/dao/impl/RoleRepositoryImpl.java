package com.charlie.tomcat.dao.impl;

import com.charlie.tomcat.dao.RoleRepository;
import com.charlie.tomcat.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
//    private JdbcOperations jdbcOperations;
    private NamedParameterJdbcOperations jdbcOperations;

    private static final String SQL_INSERT_ROLE = " insert into t_role ( name) values (?)";

    private static final String SELECT_ROLE_BY_ID = "select id, name from t_role where id = ?";

    private static final String SQL_INSERT_ROLE_NAMED = "insert into t_role ( name) values (:name)";
    private static final String SELECT_ROLE_BY_ID_NAMED = "select id, name from t_role where id=(:id)";

//    @Override
//    public void addRole(Role role) {
//        jdbcOperations.update(SQL_INSERT_ROLE, role.getName());
//    }

    @Override
    public void addRole(Role role) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", role.getName());
        jdbcOperations.update(SQL_INSERT_ROLE_NAMED, paramMap);
    }

    @Override
    public Role findOne(Long id) {
//        return jdbcOperations.queryForObject(SELECT_ROLE_BY_ID, new RoleRowMapper(), id);
//        return jdbcOperations.queryForObject(SELECT_ROLE_BY_ID, (resultSet, rowNum) -> new Role(resultSet.getLong("id"), resultSet.getString("name")), id);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return jdbcOperations.queryForObject(SELECT_ROLE_BY_ID_NAMED, paramMap, new RoleRowMapper());
    }



    private static final class RoleRowMapper implements RowMapper<Role> {

        @Override
        public Role mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Role(resultSet.getLong("id"), resultSet.getString("name"));
        }
    }


}
