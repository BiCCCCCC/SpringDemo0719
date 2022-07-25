package cn.edu.swu.bc.service.impl;

import cn.edu.swu.bc.dao.RoleDao;
import cn.edu.swu.bc.domain.Role;
import cn.edu.swu.bc.service.RoleService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource(name="roleDao")
    private RoleDao roleDao;

    @Override
    public List<Role> list() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }


    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
