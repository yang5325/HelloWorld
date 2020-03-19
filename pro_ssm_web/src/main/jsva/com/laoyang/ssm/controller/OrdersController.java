package com.laoyang.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.laoyang.ssm.domain.Orders;
import com.laoyang.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    /**
     * 没有PageHelper
     * @param mv
     * @return
     */
//    @RequestMapping("/findAll")
//    public ModelAndView findAll(ModelAndView mv){
//        List<Orders> orders = ordersService.findAll();
//        for(Orders orders1 :orders){
//            System.out.println(orders1);
//        }
//        mv.addObject("ordersList",orders);
//        mv.setViewName("orders-list");
//        return mv;
//    }


    /**
     * 有PageHelper
     * @param
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(value = "page") int page,@RequestParam("pageSize") int pageSize){
        ModelAndView mv = new ModelAndView();
        List<Orders> orders = ordersService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(orders);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }


    /**
     * 根据订单id查询订单详情
     * @param id
     * @param mv
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam("id") Integer id,ModelAndView mv){
        Orders orders = ordersService.findById(id);
        System.out.println("---"+orders+"--------");
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }


}
