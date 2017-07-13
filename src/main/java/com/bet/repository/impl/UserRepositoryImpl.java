package com.bet.repository.impl;

import com.bet.domain.UserInfo;
import com.bet.repository.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pengweiyuan on 12/07/2017.
 */
@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UserInfo> findAllAndOrder() {
        return jdbcTemplate.query("SELECT id,username,mobile,real_name,role,create_at FROM user_info WHERE 1=1 ORDER BY  create_at DESC", new RowMapper<UserInfo>() {
            @Override
            public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(resultSet.getLong("id"));
                userInfo.setUsername(resultSet.getString("username"));
                userInfo.setMobile(resultSet.getString("mobile"));
                userInfo.setRealName(resultSet.getString("real_name"));
                userInfo.setRole(resultSet.getInt("role"));
                userInfo.setCreateAt(resultSet.getDate("create_at"));
                return userInfo;
            }
        });
    }
}
