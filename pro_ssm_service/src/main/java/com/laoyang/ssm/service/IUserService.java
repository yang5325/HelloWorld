package com.laoyang.ssm.service;

import com.laoyang.ssm.domain.Role;
import com.laoyang.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

//用户登录认证
public interface IUserService extends UserDetailsService {

    /**
     * 查询所有
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 新建用户
     * @param userInfo
     */
    void save(UserInfo userInfo);

    /**
     * 根据用户id 查询详情
     * @param id
     * @return
     */
    UserInfo findById(Integer id);


    /**
     * 查询未拥有的角色信息
     * @param userId 用户id
     * @return
     */
    List<Role> findCanRoles(Integer userId);

    /**
     * 给用户赋予角色信息
     * @param userId    用户id
     * @param ids       角色id的集合
     */
    void addRoleTOUser(Integer userId, Integer[] ids);
}
