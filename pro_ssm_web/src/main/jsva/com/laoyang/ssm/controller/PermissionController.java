package com.laoyang.ssm.controller;

import com.laoyang.ssm.domain.Permission;
import com.laoyang.ssm.domain.Role;
import com.laoyang.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/permission")
@Controller
public class PermissionController  {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView mv){
        List<Permission> permissions = permissionService.findAll();
        mv.addObject("permissionList",permissions);
        mv.setViewName("permission-list");
        return mv;
    }


    @RequestMapping("/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll";
    }
}
