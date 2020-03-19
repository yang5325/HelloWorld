package com.laoyang.ssm.controller;

import com.laoyang.ssm.domain.Orders;
import com.laoyang.ssm.domain.Role;
import com.laoyang.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.SimpleFormatter;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;


    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView mv){
        List<Role> roles = roleService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }


    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam("id") Integer id, ModelAndView mv){
        Role role = roleService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }


    @RequestMapping("/delete")
    public String delete(Integer id){
        roleService.delete(id);
        return "redirect:findAll";
    }
}
