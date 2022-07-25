package cn.edu.swu.bc.service;

import cn.edu.swu.bc.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {
    List<Role> list();

    void save(Role role);
}
