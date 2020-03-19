package com.laoyang.ssm.controller;


import com.laoyang.ssm.domain.Role;
import com.laoyang.ssm.domain.UserInfo;
import com.laoyang.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private IUserService userService;

    /**
     * 用户管理功能的查询所有
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("UserInfoController.findAll");
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfos = userService.findAll();
        mv.addObject("userList",userInfos);
        mv.setViewName("user-list");
        return mv;
    }


    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll";
    }


    @RequestMapping("/findById")
    public ModelAndView findById(Integer id)throws Exception{
        UserInfo userInfo = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        System.out.println("查询到的用户信息=="+userInfo);
        return mv;
    }


    @RequestMapping("/updata")
    public ModelAndView updata(UserInfo userInfo){
        ModelAndView mv = new ModelAndView();
        System.out.println("获取的userInfo"+userInfo);
        System.out.println("停止系统。。。。。。。。。。。。。。。。。。。。。。。。。。。");
        System.exit(1);
        return mv;
    }


    /**
     * 给用户赋予某个角色
     * @param userId  用户id
     * @return
     */
    @RequestMapping("/findCanRoles")
    public ModelAndView findCanRoles(Integer userId){
        List<Role> roles = userService.findCanRoles(userId);
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(userId);

        mv.addObject("user",userInfo);
        mv.addObject("roleList",roles);
        mv.setViewName("user-add-role");
        return mv;
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam("userId") Integer userId,
                                @RequestParam("ids") Integer[] ids){
        userService.addRoleTOUser(userId,ids);
        return "redirect:findById?id="+userId;
    }



    @RequestMapping("/world")
    public String world(){
        System.out.println("helloworld,......................");
        return "redirect:/index.jsp";
    }
}
