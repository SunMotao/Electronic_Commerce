package com.iotek.dao.impl;

import com.iotek.dao.BaseDao;
import com.iotek.dao.CustomerDao;
import com.iotek.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaohuang on 2018/1/13.
 */

public class CustomerDaoImpl extends BaseDao implements CustomerDao {
    @Override
    public boolean saveCustomer(Customer customer) {
        String sql = "INSERT INTO customer(customer_name," +
                "customer_password,customer_email,customer_phone," +
                "customer_money) VALUES(?,?,?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(customer.getCustomerName());
        params.add(customer.getCustomerPassword());
        params.add(customer.getCustomerEmail());
        params.add(customer.getCustomerPhone());
        params.add(customer.getCustomerMoney());
        return update(sql, params);

    }

    /*   更新指定id的用户名的密码*/
    @Override
    public boolean updateCustomerPassword(Customer customer) {
        String sql = "UPDATE custoemr SET " +
                " customer_password=? WHERE id=?";
        List<Object> params = new ArrayList<>();
        params.add(customer.getCustomerPassword());
        params.add(customer.getId());

        return update(sql, params);
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        String sql = "DELETE FROM customer where id=?";
        List<Object> params = new ArrayList<>();
        params.add(customer.getId());
        return update(sql, params);
    }

    @Override
    public Customer queryCustomerByName(Customer customer) {
        String sql = "SELECT id,customer_name,customer_password,customer_email,customer_phone " +
                "  FROM customer  where  customer_name=? and customer_password=?";
        List<Object> params = new ArrayList<>();
        params.add(customer.getCustomerName());
        params.add(customer.getCustomerPassword());
        List<Customer> query = query(sql, params, Customer.class);
        if (query.size() > 0) {
            return query.get(0);
        }
        return null;

      /*  Connection connection = null;
        PreparedStatement ps = null;

        Customer customer1 = null;
        ResultSet rs = null;
        try {
            connection = getconn();
            ps = connection.prepareStatement(sql);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerPassword());
            rs = ps.executeQuery();

            if (rs!=null) {
                while (rs.next()) {
                    customer1 = new Customer();
    //                可以通过列的名字获取当前行的所对应的列的值 或者根据列编号获取
                    customer1.setId(rs.getInt("id"));
                    customer1.setCustomerName(rs.getString("customer_name"));
                    customer1.setCustomerPassword(rs.getString("customer_password"));
                    customer1.setCustomerEmail(rs.getString("customer_email"));
                    customer1.setCustomerPhone(rs.getString("customer_phone"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, connection);
        }


        return customer1;*/
    }
}
