package com.iotek.service.impl;

import com.iotek.dao.ProductDao;
import com.iotek.dao.impl.ProductDaoImpl;
import com.iotek.entity.Product;
import com.iotek.service.ProductService;

import java.math.BigDecimal;

/**
 * Created by xiaohuang on 2018/1/16.
 */
public class ProductSericeImpl implements ProductService {
    private ProductDao productDao;

    public ProductSericeImpl() {
        productDao=new ProductDaoImpl();
    }

    @Override
    public boolean addProduct(Product product) {

        return productDao.addProduct(product);
    }

    @Override
    public boolean updateProductPrice(Product product) {
        return productDao.updateProductPrice(product);
    }

    @Override
    public boolean addProductAndaddPrice(Product product, Double addPrice) {
        boolean addProduct = addProduct(product);
        if (addProduct){
            product.setProudctPrice(new BigDecimal(product.getProudctPrice().doubleValue()+addPrice));
            updateProductPrice(product);
        }


        return false;
    }

}
