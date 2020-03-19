package com.laoyang.ssm.service.impl;

import com.laoyang.ssm.dao.IRoleDao;
import com.laoyang.ssm.dao.IUserDao;
import com.laoyang.ssm.domain.Role;
import com.laoyang.ssm.domain.UserInfo;
import com.laoyang.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 用户管理功能的查询所有
     * @return
     */
    @Override
    public List<UserInfo> findAll(){
        return userDao.findAll();
    }


    /**
     * 保存用户信息
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo) {
        //对密码进行加密处理
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }


    /**
     * 用户详情查询
     * @param id
     * @return
     */
    @Override
    public UserInfo findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findCanRoles(Integer userId) {
        List<Role> roles = userDao.findCanRoles(userId);
        return roles;
    }

    @Override
    public void addRoleTOUser(Integer userId, Integer[] ids) {
        for (int id :ids){
            userDao.addRoleToUser(userId,id);
        }
    }


    /**
     * 登录全限认证、spring security自调用
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByName(username);
        System.out.println("查询的角色信息=");
        System.out.println(userInfo.getRoles());
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),
                userInfo.getStatus() == 1,true,true,
                true,getAuthority(userInfo.getRoles()));
        return user;
    }
    //登录权限认证
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role role:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

}
