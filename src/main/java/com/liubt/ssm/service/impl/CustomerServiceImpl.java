package com.liubt.ssm.service.impl;/*
 *FileName:  CustomerServiceImpl
 * Author:   zhaoly
 * Date  :   2020/10/16 22:38
 * */

import com.liubt.ssm.mapper.CustomerMapper;
import com.liubt.ssm.pojo.Customer;
import com.liubt.ssm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description：用户服务实现层
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Override
    @Transactional
    public Integer saveCustomer(Customer customer) {
        return customerMapper.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Integer deleteCustomer(Integer custId) {
        return customerMapper.deleteCustomer(custId);
    }

    @Override
    @Transactional
    public Integer updateCusTomerByCustId(Customer customer) {
        return customerMapper.updateCusTomerByCustId(customer);
    }

    @Override
    public Customer findCustomerByCustId(Integer custId) {
        return customerMapper.findCustomerByCustId(custId);
    }

    @Override
    public List<Customer> findAll() {
        return customerMapper.findAll();
    }
}
