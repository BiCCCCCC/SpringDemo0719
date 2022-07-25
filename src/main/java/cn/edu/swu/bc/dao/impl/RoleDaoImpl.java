package cn.edu.swu.bc.dao.impl;

import cn.edu.swu.bc.dao.RoleDao;
import cn.edu.swu.bc.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Role> findAll() {
        return jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<>(Role.class));
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values (?,?,?)", null, role.getRoleName(), role.getRoleDesc());
    }

    @Override
    public List<Role> findRolesByUserId(Long id) {
        return jdbcTemplate.query(
                "select * from sys_user_role , sys_role where sys_user_role.roleId=sys_role.id and sys_user_role.userId=?"
                , new BeanPropertyRowMapper<>(Role.class), id);

    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
