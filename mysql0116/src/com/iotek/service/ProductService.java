package com.iotek.service;

import com.iotek.entity.Product;

/**
 * Created by xiaohuang on 2018/1/16.
 */
public interface ProductService {
    boolean addProduct(Product product);

    boolean updateProductPrice(Product product);

//    ���Ӳ�����
    boolean  addProductAndaddPrice(Product product,Double addPrice);

}
