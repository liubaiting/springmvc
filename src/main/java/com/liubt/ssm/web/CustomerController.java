package com.liubt.ssm.web;/*
 *FileName:  CustomerController
 * Author:   zhaoly
 * Date  :   2020/10/16 22:40
 * */

import com.liubt.ssm.pojo.Customer;
import com.liubt.ssm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Description：
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    /**
     * @Description 查询用户列表
     */
    @RequestMapping("list")
    public String list(Model model) {
        List<Customer> list = customerService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    /**
     * @Description 去添加页面
     */
    @RequestMapping("toAdd")
    public String toAdd() {
        return "add";

    }

    /**
     * @Description 添加操作
     */
    @RequestMapping("doAdd")
    public String doAdd(Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";

    }

    /**
     * @param customerId 用户ID
     * @return
     * @Description 删除操作
     */
    @RequestMapping("doDel")
    public String doDel(Integer customerId) {
        customerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }

    /**
     * @param customerId 用户ID
     * @return
     * @Description 去修改页面
     */
    @RequestMapping("toUpdate")
    public String toUpdate(Model model, Integer customerId) {
        Customer customer = customerService.findCustomerByCustId(customerId);
        model.addAttribute("customer", customer);
        return "update";
    }

    /**
     * @param customer 修改对象
     * @return
     * @Description 修改操作
     */
    @RequestMapping("doUpdate")
    public String doUpdate(Customer customer) {
        customerService.updateCusTomerByCustId(customer);
        return "redirect:/customer/list";
    }
}
