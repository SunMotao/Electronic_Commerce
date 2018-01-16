package com.iotek.dao;

import com.iotek.entity.Customer;

/**
 * Created by xiaohuang on 2018/1/13.
 */
public interface CustomerDao {
    /**
     * @param customer
     * @return boolean
     * �����û�
     */
    boolean saveCustomer(Customer customer);

    //    �����û�����
    boolean updateCustomerPassword(Customer customer);

    //    ɾ���û�
    boolean deleteCustomer(Customer customer);


//     ͨ���û����������ѯ�û�
    Customer  queryCustomerByName(Customer customer);


}
