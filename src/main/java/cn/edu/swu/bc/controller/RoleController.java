package cn.edu.swu.bc.controller;

import cn.edu.swu.bc.domain.Role;
import cn.edu.swu.bc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list() {

        ModelAndView modelAndView = new ModelAndView();
        //设置模型
        modelAndView.addObject("roleList", roleService.list());
        //设置视图
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/role/list";
    }
}
