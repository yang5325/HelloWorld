package com.laoyang.ssm.dao;

import com.laoyang.ssm.domain.Role;
import com.laoyang.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    /**
     * 根据用户名查找用户
     *  用户登录认证管理
     * @param userName
     * @return
     */
    UserInfo findByName(String userName);

    /**
     * 用户管理功能的查询所有用户
     * @return
     */
    List<UserInfo> findAll();


    /**
     * 用户管理的新建功能
     * @param userInfo
     */
    void save(UserInfo userInfo);


    /**
     * 用户管理的详情功能
     * 根据用户id查询用户详情
     * @param id
     * @return
     */
    UserInfo findById(Integer id);



    /**
     * 查询所有未拥有的角色信息
     * @param userId 用户id
     * @return
     */
    List<Role> findCanRoles(Integer userId);

    /**
     * 给用户添加角色
     * @param userId
     * @param id
     */
    void addRoleToUser(@Param("userId") Integer userId, @Param("roleId") int id);

}
