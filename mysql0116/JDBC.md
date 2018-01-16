# JDBC
java数据库连接

## 导入需要驱动数据库jar包

## 步骤 ：

  加载驱动

    Class.forName(DRIVER);

  连接数据库
```
connection=  DriverManager.getConnection(URL, USERNAME,PASSWORD);
```

  执行sql语句
     1:直接执行
     ```
     Statement statement = connection.createStatement();
     int i = statement.executeUpdate(sql);
     ```
     2：通过预编译的方式执行
    通过？号进行占位


  处理结果

    if (i>0){
              return  true;
          }

  关闭资源

    statement.close();
    connection.close();

 查询：


