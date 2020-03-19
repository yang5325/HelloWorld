package com.laoyang.ssm.dao;

import com.laoyang.ssm.domain.Traveller;
import org.springframework.stereotype.Repository;

import java.util.List;

//旅客
@Repository
public interface ITravellerDao {

    /**
     * 订单管理页面的详情功能
     *  根据订单id获取旅客信息
     * @param id
     * @return
     */
    Traveller findById(Integer id);


}
