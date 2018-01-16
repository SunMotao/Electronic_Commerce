package com.iotek.dao.impl;

import com.iotek.dao.BaseDao;
import com.iotek.dao.ProductDao;
import com.iotek.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaohuang on 2018/1/16.
 */
public class ProductDaoImpl extends BaseDao implements ProductDao {
    @Override
    public List<Product> queryAllProduct() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet  rs=null;
        List<Product> productList=new ArrayList<>();
        String  sql="select id,product_name,product_price," +
                "product_type " +
                "from product";
        try {
            connection=getconn();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs!=null){
                while (rs.next()){
                    Product product=new Product();
                    product.setId(rs.getInt("id"));
                    product.setProductName(rs.getString("product_name"));
                    product.setProudctPrice(rs.getBigDecimal("product_price"));
                    product.setProductType(rs.getString("product_type"));
                    productList.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs,ps,connection);
        }

        return  productList;


    }

    @Override
    public boolean addProduct(Product product) {

        String sql="insert into  product(product_name,product_price" +
                " ,product_type, product_create_time, product_modified_time)" +
                " values(?,?,?,?,?)";
        List<Object> params=new ArrayList<>();
        params.add(product.getProductName());
        params.add(product.getProudctPrice());
        params.add(product.getProductType());
        params.add(product.getProductCreateTime());
        params.add(product.getProductMofifiedTime());
        List<Integer> ids = updateReturnId(sql, params);
        if (ids.size()>0){
            product.setId(ids.get(0));

            return true;
        }

        return false;
    }

    @Override
    public boolean updateProductPrice(Product product) {
      String sql="update  product set  product_price=? where id=?";
        List<Object> params=new ArrayList<>();
        params.add(product.getProudctPrice());
        params.add(product.getId());
        return update(sql,params);
    }
}
