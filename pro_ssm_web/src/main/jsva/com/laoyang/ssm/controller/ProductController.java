package com.laoyang.ssm.controller;

import com.laoyang.ssm.domain.Product;
import com.laoyang.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView mv) throws Exception {
        List<Product> products = productService.findAll();
        mv.addObject("productList",products);
        mv.setViewName("product-list1");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Product product) throws Exception {
        System.out.println("product = " + product);
        productService.save(product);
        return "redirect:findAll";
    }




}
