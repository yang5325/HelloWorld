package com.laoyang.ssm.service;


import com.laoyang.ssm.domain.Role;

import java.util.List;

public interface IRoleService {


    List<Role> findAll();


    void save(Role role);

    Role findById(Integer id);

    void delete(Integer id);
}
