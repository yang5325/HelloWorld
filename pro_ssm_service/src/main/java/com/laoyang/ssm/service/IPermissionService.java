package com.laoyang.ssm.service;

import com.laoyang.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAll();

    void save(Permission permission);
}
