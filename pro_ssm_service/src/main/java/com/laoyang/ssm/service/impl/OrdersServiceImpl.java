package com.laoyang.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.laoyang.ssm.dao.IOrdersDao;
import com.laoyang.ssm.domain.Orders;
import com.laoyang.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return ordersDao.findAll();
    }

    @Override
    public List<Orders> findAll() {
        PageHelper.startPage(1,5);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(Integer id) {
        return ordersDao.findById(id);
    }
}
