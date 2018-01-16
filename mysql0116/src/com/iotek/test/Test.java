package com.iotek.test;

import com.iotek.dao.BaseDao;
import com.iotek.dao.CustomerDao;
import com.iotek.dao.ProductDao;
import com.iotek.dao.impl.CustomerDaoImpl;
import com.iotek.dao.impl.ProductDaoImpl;
import com.iotek.entity.Color;
import com.iotek.entity.Customer;
import com.iotek.entity.Product;
import com.iotek.service.ProductService;
import com.iotek.service.impl.ProductSericeImpl;

import java.io.BufferedInputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by xiaohuang on 2018/1/13.
 */
public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
     /*   Customer customer=new Customer();
        customer.setCustomerName("xiaohuang");
        customer.setCustomerPassword("1234567");
        CustomerDao customerDao=new CustomerDaoImpl();
        Customer customer1 = customerDao.queryCustomerByName(customer);
        System.out.println(customer1);*/

        /*Class<Customer> customerClass = Customer.class;
        Field[] fields = customerClass.getFields();*/

    }
}
