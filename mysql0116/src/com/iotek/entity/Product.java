package com.iotek.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by xiaohuang on 2018/1/16.
 */
public class Product {
    public   static  final  int   PRODUCT_IS_DELETED=1; //ÒÑÉ¾³ý
    public   static  final  int   PRODUCT_IS_NOT_DELETED=0; //Î´É¾³ý
    public   static  final  int   PRODUCT_IS__DELETED_DEFLULT=PRODUCT_IS_NOT_DELETED; //Ä¬ÈÏÖµÎ´É¾³ý
    private  Integer  id;
    private String productName;
    private BigDecimal proudctPrice;
    private String   productType;
    private Integer  productIsDeleted;
    private Timestamp productCreateTime;
    private Timestamp productMofifiedTime;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProudctPrice() {
        return proudctPrice;
    }

    public void setProudctPrice(BigDecimal proudctPrice) {
        this.proudctPrice = proudctPrice;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getProductIsDeleted() {
        return productIsDeleted;
    }

    public void setProductIsDeleted(Integer productIsDeleted) {
        this.productIsDeleted = productIsDeleted;
    }

    public Timestamp getProductCreateTime() {
        return productCreateTime;
    }

    public void setProductCreateTime(Timestamp productCreateTime) {
        this.productCreateTime = productCreateTime;
    }

    public Timestamp getProductMofifiedTime() {
        return productMofifiedTime;
    }

    public void setProductMofifiedTime(Timestamp productMofifiedTime) {
        this.productMofifiedTime = productMofifiedTime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", proudctPrice=" + proudctPrice +
                ", productType='" + productType + '\'' +
                ", productIsDeleted=" + productIsDeleted +
                ", productCreateTime=" + productCreateTime +
                ", productMofifiedTime=" + productMofifiedTime +
                '}';
    }
}
