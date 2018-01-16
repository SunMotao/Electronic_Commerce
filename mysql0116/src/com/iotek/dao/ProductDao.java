package com.iotek.dao;

import com.iotek.entity.Product;

import java.util.List;

/**
 * Created by xiaohuang on 2018/1/16.
 */
public interface ProductDao {
    List<Product> queryAllProduct();
    boolean  addProduct(Product product);
    boolean  updateProductPrice(Product product);
}
