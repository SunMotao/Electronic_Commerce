package com.iotek.dao;

import com.iotek.entity.Customer;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Map;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by xiaohuang on 2018/1/13.
 */
public class BaseDao {
    private static String DRIVER = null;
    private static String URL = null;
    private static String USERNAME = null;
    private static String PASSWORD = null;

    static {
//        加载驱动
        init();
    }

    private static void init() {
        BufferedReader br = null;
        try {
            File file = new File("mysql.properties");

            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file)));
            String s = null;

            while ((s = br.readLine()) != null) {
                s = s.trim();
                if (s.charAt(0) != '#' && s.length() > 0) {
                    String[] strings = s.split("=");
                    String key = strings[0].trim();
                    String value = strings[1].trim();
                    if ("DRIVER".equals(key.toUpperCase())) {
                        DRIVER = value;
                    }
                    if ("URL".equals(key.toUpperCase())) {
                        URL = value;
                    }
                    if ("USERNAME".equals(key.toUpperCase())) {
                        USERNAME = value;
                    }
                    if ("PASSWORD".equals(key.toUpperCase())) {
                        PASSWORD = value;
                    }

                }
            }
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getconn() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean update(String sql, List<Object> params) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = getconn();
        int num = 0;
        try {
            if (params != null) {

                statement = connection.prepareStatement(sql);

                for (int i = 0; i < params.size(); i++) {
                    statement.setObject(i + 1, params.get(i));
                }
                num = statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, statement, connection);
        }

        if (num > 0) {
            return true;
        }
        return false;


    }

    public List<Integer> updateReturnId(String sql, List<Object> params) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = getconn();

        List<Integer> idList = new ArrayList<>();
        ResultSet rs = null;
        int num = 0;
        try {
            if (params != null) {

                statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                for (int i = 0; i < params.size(); i++) {
                    statement.setObject(i + 1, params.get(i));
                }
                num = statement.executeUpdate();
                rs = statement.getGeneratedKeys();
                if (rs != null) {
                    while (rs.next()) {
                        idList.add(rs.getInt(1));
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, statement, connection);
        }


        return idList;


    }


    public void close(ResultSet rs, Statement statement, Connection connection) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
//    String  sql="select * from customer where id=?"
//    params.add(1)
//        Customer.class

    public <T> List<T> query(String sql, List<Object> params, Class<T> tClass) {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = getconn();
        ResultSet rs = null;
        List<T> tList = new ArrayList<T>();
        int num = 0;
        try {
//             循环占位
            if (params != null) {

                statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                for (int i = 0; i < params.size(); i++) {
                    statement.setObject(i + 1, params.get(i));
                }


            }

            rs = statement.executeQuery();
            if (rs == null)
                return tList;

            ResultSetMetaData metaData = rs.getMetaData();
//            metaData.getColumnCount()--  列的数量
//            metaData.getColumnLabel(i) 获取第i列的标题
            while (rs.next()) {
                Customer customer = new Customer();
                try {
//                    Customer  customer=new Customer();
                    T t = tClass.newInstance();
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {

                        String colmunName = metaData.getColumnLabel(i);
                        Field field = tClass.getDeclaredField(parseCol(colmunName));
                        field.setAccessible(true);
                        field.set(t, rs.getObject(colmunName));

                    }
                    tList.add(t);


                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null, statement, connection);
        }

        return tList;
    }

    private  static  String parseCol(String colmunName) {
//        "customer is  deleted"


        if (colmunName == null) {
            throw  new  NullPointerException();
        }
        String[] split = colmunName.toLowerCase().split("_");
        String field = split[0].trim();
        for (int i = 1; i < split.length; i++) {
            if (split[i] != null) {
                field += String.valueOf(split[i].charAt(0)).toUpperCase();
                field += split[i].substring(1, split[i].length());
            }

        }

        return field;

    }


}
