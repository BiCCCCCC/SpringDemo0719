package cn.edu.swu.bc.dao.impl;

import cn.edu.swu.bc.dao.UserDao;
import cn.edu.swu.bc.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;


    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public long save(final User user) {

        final PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //使用原始jdbc完成带有PreparedStatement的组件
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhoneNum());
                return preparedStatement;
            }
        };
        //形成生成主键
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public void saveUserRoleRel(Long userId, long[] roleIds) {
        for (long roleId : roleIds
        ) {
            jdbcTemplate.update("insert into sys_user_role values (?,?)",
                    userId, roleId);
        }
    }

    @Override
    public void delUserRoleRel(long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?",userId);
    }

    @Override
    public void delUser(long userId) {
        jdbcTemplate.update("delete from sys_user where id=?",userId);
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
