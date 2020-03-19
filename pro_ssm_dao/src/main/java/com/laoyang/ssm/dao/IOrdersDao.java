package com.laoyang.ssm.dao;

import com.laoyang.ssm.domain.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdersDao {

    /**
     * 查询所有订单
     * @return
     */
    List<Orders> findAll();

    /**
     * 根据订单id查询订单
     * @param id
     * @return
     */
    Orders findById(Integer id);
}
