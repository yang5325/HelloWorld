package com.laoyang.ssm.dao;

import com.laoyang.ssm.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleDao {


    /**
     * 根据用户id查询所有角色和对应权限
     * @param id 用户名的id
     * @return
     */
    List<Role> findById(Integer id);


    /**
     * 安全认证时查询角色名需要、未查权限信息
     * @param id    用户名的id
     * @return
     */
    List<Role> findOnlyRoleById(Integer id);

    /**
     * 点击角色管理、
     * 查询所有角色
     * @return
     */
    List<Role> findAll();

    /**
     * 角色管理的新建角色
     * @param role
     */
    void save(Role role);

    /**
     * 角色管理的查询详情
     * @param id 角色id
     * @return
     */
    Role findRoleDesc(Integer id);

    /**
     * 删除角色和用户的关联
     * @param id    角色id
     */
    void deleteRole_User(Integer id);

    /**
     * 删除角色和权限的关联
     * @param id    角色id
     */
    void deleteRole_Permission(Integer id);

    /**
     * 删除该角色
     * @param id    角色id
     */
    void deleteRole(Integer id);
}

