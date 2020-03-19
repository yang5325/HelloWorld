package com.laoyang.ssm.dao;


import com.laoyang.ssm.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限实体类
 */
@Repository
public interface IPermission {

    /**
     * 根据角色id查询权限信息
     * @param id
     * @return
     */
    List<Permission> findById(Integer id);


    /**
     * 权限管理的查询所有
     * @return
     */
    List<Permission> findAll();

    /**
     * 权限管理的新建功能
     * @param permission
     */
    void save(Permission permission);
}
