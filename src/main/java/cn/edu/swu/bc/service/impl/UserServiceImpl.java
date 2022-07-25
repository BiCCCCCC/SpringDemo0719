package cn.edu.swu.bc.service.impl;

import cn.edu.swu.bc.dao.RoleDao;
import cn.edu.swu.bc.domain.Role;
import cn.edu.swu.bc.domain.User;
import cn.edu.swu.bc.dao.UserDao;
import cn.edu.swu.bc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        //封装userList中每一个user的roles数据
        for (User user:userList
             ) {
            Long id=user.getId();
            //查询role
            List<Role> roleList= roleDao.findRolesByUserId(id);
            user.setRoleList(roleList);
        }
        return userList;
    }

    @Override
    public void save(User user,long[]roleIds) {
        //存用户
        Long userId= userDao.save(user);
        //存关系
        userDao.saveUserRoleRel(userId,roleIds);
    }

    @Override
    public void del(long userId) {
        //1.删除sys_user_role关系表
        userDao.delUserRoleRel(userId);
        //2.删除sys_user表
        userDao.delUser(userId);
    }

}
