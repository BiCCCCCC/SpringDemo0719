package cn.edu.swu.bc.dao;

import cn.edu.swu.bc.domain.Role;
import cn.edu.swu.bc.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface UserDao {
    List<User> findAll();


    long save(User user);

    void saveUserRoleRel(Long userId, long[] roleIds);

    void delUserRoleRel(long userId);

    void delUser(long userId);

    User findByUsernameAndPassword(String username, String password)throws EmptyResultDataAccessException;
}
