package com.iotek.service;

import com.iotek.entity.Product;

/**
 * Created by xiaohuang on 2018/1/16.
 */
public interface ProductService {
    boolean addProduct(Product product);

    boolean updateProductPrice(Product product);

//    增加并更新
    boolean  addProductAndaddPrice(Product product,Double addPrice);

}
