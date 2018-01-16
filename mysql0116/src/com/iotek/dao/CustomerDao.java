package com.iotek.dao;

import com.iotek.entity.Customer;

/**
 * Created by xiaohuang on 2018/1/13.
 */
public interface CustomerDao {
    /**
     * @param customer
     * @return boolean
     * 增加用户
     */
    boolean saveCustomer(Customer customer);

    //    更新用户密码
    boolean updateCustomerPassword(Customer customer);

    //    删除用户
    boolean deleteCustomer(Customer customer);


//     通过用户名和密码查询用户
    Customer  queryCustomerByName(Customer customer);


}
