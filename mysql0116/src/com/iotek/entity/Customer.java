package com.iotek.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by xiaohuang on 2018/1/13.
 */

public class Customer/* extends BaseEntity<Integer>*/ {

    public static final Integer CUSTOMER_IS_NORMAL = 1;
    public static final Integer CUSTOMER_IS_NOT_NORMAL = 0;

//    transient  ·ÀÖ¹×Ö¶ÎÐòÁÐ»¯
    private  Integer  id;
    private String customerName;
    private  transient String customerPassword;
    private String customerEmail;
    private String customerPhone;
    private BigDecimal customerMoney;
    private Integer customerIsNormal;
    private Timestamp customerLoginTime;
    private Timestamp customerCreateTime;
    private Timestamp customerModifiedTime;

    public Customer() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public BigDecimal getCustomerMoney() {
        return customerMoney;
    }

    public void setCustomerMoney(BigDecimal customerMoney) {
        this.customerMoney = customerMoney;
    }

    public Integer getCustomerIsNormal() {
        return customerIsNormal;
    }

    public void setCustomerIsNormal(Integer customerIsNormal) {
        this.customerIsNormal = customerIsNormal;
    }

    public Timestamp getCustomerLoginTime() {
        return customerLoginTime;
    }

    public void setCustomerLoginTime(Timestamp customerLoginTime) {
        this.customerLoginTime = customerLoginTime;
    }

    public Timestamp getCustomerCreateTime() {
        return customerCreateTime;
    }

    public void setCustomerCreateTime(Timestamp customerCreateTime) {
        this.customerCreateTime = customerCreateTime;
    }

    public Timestamp getCustomerModifiedTime() {
        return customerModifiedTime;
    }

    public void setCustomerModifiedTime(Timestamp customerModifiedTime) {
        this.customerModifiedTime = customerModifiedTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerPassword='" + customerPassword + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerMoney=" + customerMoney +
                ", customerIsNormal=" + customerIsNormal +
                ", customerLoginTime=" + customerLoginTime +
                ", customerCreateTime=" + customerCreateTime +
                ", customerModifiedTime=" + customerModifiedTime +
                '}';
    }
}
