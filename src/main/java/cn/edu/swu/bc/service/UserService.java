package cn.edu.swu.bc.service;

import cn.edu.swu.bc.domain.User;

import java.util.List;

public interface UserService {

    List<User> list();

    void save(User user,long[]roleIds);

    void del(long userId);

    User login(String username, String password);
}
