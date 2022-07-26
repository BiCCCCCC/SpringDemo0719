package cn.edu.swu.bc.test;


import cn.edu.swu.bc.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void updateTest(){

        System.out.println("===============================================================");
        System.out.println(jdbcTemplate.queryForObject("select count(*) from sys_role ", long.class));
        System.out.println("================================================================");
    }

    @Test
    public void userTest(){

        User user= jdbcTemplate.queryForObject("select * from sys_user where username=?",
                new BeanPropertyRowMapper<User>(User.class), "bc");
        System.out.println(user);
    }
}