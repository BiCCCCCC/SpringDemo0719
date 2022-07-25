package cn.edu.swu.bc.dao;

import cn.edu.swu.bc.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleDao {
    List<Role>findAll();

    void save(Role role);

    List<Role> findRolesByUserId(Long id);
}
