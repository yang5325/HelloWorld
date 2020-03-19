package com.laoyang.ssm.service;

import com.laoyang.ssm.domain.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IOrdersService {

    /**
     * 查询所有
     * @return
     */
    List<Orders> findAll();

    /**
     * 分页查询所有
     * @param page
     * @param pageSize
     * @return
     */
    List<Orders> findAll(Integer page,Integer pageSize);

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    Orders findById(Integer id);
}
