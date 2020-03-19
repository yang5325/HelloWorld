package com.laoyang.ssm.service.impl;

import com.laoyang.ssm.dao.IRoleDao;
import com.laoyang.ssm.domain.Role;
import com.laoyang.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }


    @Override
    public Role findById(Integer id) {
        return roleDao.findRoleDesc(id);
    }

    @Override
    public void delete(Integer id) {
        roleDao.deleteRole_User(id);
        roleDao.deleteRole_Permission(id);
        roleDao.deleteRole(id);
    }
}
