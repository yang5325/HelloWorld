package com.laoyang.ssm.dao;

import com.laoyang.ssm.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {

    /**
     * 根据产品id查询产品
     * @param id
     * @return
     * @throws Exception
     */
    Product findById(Integer id) throws Exception;

    /**
     * 查询所有的产品信息
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;

    /**
     * 新建产品
     * @param product
     */
    void save(Product product);
}
