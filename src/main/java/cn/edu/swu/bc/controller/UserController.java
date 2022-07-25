package cn.edu.swu.bc.controller;

import cn.edu.swu.bc.domain.User;
import cn.edu.swu.bc.service.RoleService;
import cn.edu.swu.bc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list()
    {
        ModelAndView modelAndView=new ModelAndView();
        //设置数据
        modelAndView.addObject("userList",userService.list());
        //设置视图
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI()
    {
        ModelAndView modelAndView=new ModelAndView();

        //设置数据
        modelAndView.addObject("roleList",roleService.list());
        //设置视图
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user,long [] roleIds)
    {
        userService.save(user,roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/del/{userId}")
    public String del( @PathVariable long userId)
    {
        userService.del(userId);
        return "redirect:/user/list";
    }
}
