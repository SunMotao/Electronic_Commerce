# JDBC
java���ݿ�����

## ������Ҫ�������ݿ�jar��

## ���� ��

  ��������

    Class.forName(DRIVER);

  �������ݿ�
```
connection=  DriverManager.getConnection(URL, USERNAME,PASSWORD);
```

  ִ��sql���
     1:ֱ��ִ��
     ```
     Statement statement = connection.createStatement();
     int i = statement.executeUpdate(sql);
     ```
     2��ͨ��Ԥ����ķ�ʽִ��
    ͨ�����Ž���ռλ


  ������

    if (i>0){
              return  true;
          }

  �ر���Դ

    statement.close();
    connection.close();

 ��ѯ��


