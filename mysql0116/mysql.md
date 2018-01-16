
CREATE TABLE customer (
  id                     INT            AUTO_INCREMENT,
  customer_name          VARCHAR(255) NOT NULL,
  customer_password      VARCHAR(255) NOT NULL,
  customer_email         VARCHAR(255) NOT NULL,
  customer_phone         VARCHAR(255) NOT NULL,
  customer_money         DECIMAL(10, 2) DEFAULT '0.00',
  custoemr_is_normal     INT(2)         DEFAULT 1,
  customer_login_time    DATETIME,
  customer_create_time   DATETIME,
  customer_modified_time DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE admin (
  id                  INT    AUTO_INCREMENT,
  admin_name          VARCHAR(255) NOT NULL,
  admin_password      VARCHAR(255) NOT NULL,
  admin_is_normal     INT(2) DEFAULT 1,
  admin_create_time   DATETIME,
  admin_modified_time DATETIME,
  PRIMARY KEY (id)

);


CREATE TABLE product (
  id                    INT            AUTO_INCREMENT,
  product_name          VARCHAR(255) NOT NULL,
  product_price         DECIMAL(10, 2) DEFAULT '0.00',
  product_type          VARCHAR(255) NOT NULL,
  product_is_deleted    INT(2)         DEFAULT 0,
  product_create_time   DATETIME,
  product_modified_time DATETIME,
  PRIMARY KEY (id)
);


CREATE TABLE product_stock (
  id                  INT     AUTO_INCREMENT,
  product_id          INT NOT NULL,
  stock_number        INTEGER DEFAULT 0,
  stock_create_time   DATETIME,
  stock_modified_time DATETIME,
  PRIMARY KEY (id)
);


CREATE TABLE inner_stock (
  id                  INT AUTO_INCREMENT,
  product_id          INT     NOT NULL,
  inner_stock_number  INTEGER NOT NULL,
  inner_create_time   DATETIME,
  inner_modified_time DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE outer_stock (
  id                  INT AUTO_INCREMENT,
  product_id          INT     NOT NULL,
  outer_stock_number  INTEGER NOT NULL,
  outer_create_time   DATETIME,
  outer_modified_time DATETIME,
  PRIMARY KEY (id)
);


CREATE TABLE product_shelf (
  id                  INT              AUTO_INCREMENT,
  product_id          INT    NOT NULL,
  product_shelf_state INT(2) NOT NULL  DEFAULT 1,
  shelf_create_time   DATETIME,
  shelf_modified_time DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE shopcart (
  id                     INT AUTO_INCREMENT,
  product_id             INT NOT NULL,
  product_number         INT NOT NULL,
  shopcart_create_time   DATETIME,
  shopcart_modified_time DATETIME,
  PRIMARY KEY (id)
);
CREATE TABLE address (
  id                    INT AUTO_INCREMENT,
  csutomer_id           INT          NOT NULL,
  province              VARCHAR(255) NOT NULL,
  city                  VARCHAR(255) NOT NULL,
  country               VARCHAR(255) NOT NULL,
  road                  VARCHAR(255) NOT NULL,
  address_lable         VARCHAR(255) NOT NULL,
  address_create_time   DATETIME,
  address_modified_time DATETIME,
  PRIMARY KEY (id)
);
CREATE TABLE order_list (
  id                  INT     AUTO_INCREMENT,
  csutomer_id         INT NOT NULL,
  total_money         DECIMAL DEFAULT '0.00',
  address_id          INT NOT NULL,
  order_is_pay        INT(2)  DEFAULT 0,
  order_is_transport  INT(2)  DEFAULT 0,
  order_is_deleted    INT(2)  DEFAULT 0,
  order_create_timea  DATETIME,
  order_modified_time DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE order_item (
  id                 INT AUTO_INCREMENT,
  order_list_id      INT     NOT NULL,
  product_id         INT     NOT NULL,
  product_number     INTEGER NOT NULL,
  item_create_time   DATETIME,
  item_modified_time DATETIME,
  PRIMARY KEY (id)
);


CREATE TABLE discuss (
  id                    INT    AUTO_INCREMENT,
  customer_id           INT NOT NULL,
  order_item_id         INT NOT NULL,
  product_id            INT NOT NULL,
  discuss_score         INT(2) DEFAULT 5,
  discuss_is_deleted    INT(2) DEFAULT 0,
  discuss_create_time   DATETIME,
  discuss_modified_time DATETIME,
  PRIMARY KEY (id)
);

# 增加语句
INSERT INTO

  customer

  (customer_name,
   customer_password,
   customer_email,
   customer_phone,
   customer_money,
   customer_login_time,
   customer_create_time,
   customer_modified_time)

VALUES

  ('xiaohuang',
   '123456',
   '1463453224@qq.com',
   '13123234245',
   6000.00,
   current_timestamp,
   current_timestamp,
   current_timestamp);
INSERT INTO

  customer

  (customer_name,
   customer_password,
   customer_email,
   customer_phone,
   customer_login_time,
   customer_create_time,
   customer_modified_time)

VALUES

  ('李四',
   '123456111',
   '145758654@qq.com',
   '13123238934',
   current_timestamp,
   current_timestamp,
   current_timestamp);

INSERT INTO

  customer

  (customer_name,
   customer_password,
   customer_email,
   customer_phone,
   customer_login_time,
   customer_create_time,
   customer_modified_time)

VALUES

  ('张三',
   '12345689',
   '14634ss53224@qq.com',
   '13123234575',
   current_timestamp,
   current_timestamp,
   current_timestamp);

# 查询语句    *代表要查询的所有列
SELECT *
FROM
  customer;

#   查看表结构
DESC customer;

# 删除行
#   删除名字等于张三的用户
DELETE FROM customer
WHERE customer_name = '张三';

# 更新

UPDATE customer
SET customer_password = '1234567'
WHERE customer_name = 'xiaohuang';

#  通过用户名和密码查询

SELECT *
FROM customer
WHERE
  customer_name = 'xiaohuang' AND customer_password = '1234567';

# 更新用户的钱数
UPDATE customer
SET customer_money = customer_money + 1000
WHERE customer_name = 'xiaohuang';

# 增加商品
INSERT INTO product (product_name, product_price, product_type, product_create_time, product_modified_time)
VALUES ('iphone5s', 2000.01, '手机', current_timestamp, current_timestamp);

INSERT INTO product (product_name, product_price, product_type, product_create_time, product_modified_time)
VALUES ('iphone6s', 4000.01, '手机', current_timestamp, current_timestamp);


INSERT INTO product (product_name, product_price, product_type, product_create_time, product_modified_time)
VALUES ('iphone8', 6080.01, '手机', current_timestamp, current_timestamp);

INSERT INTO product (product_name, product_price, product_type, product_create_time, product_modified_time)
VALUES ('iphoneX', 8880.01, '手机', current_timestamp, current_timestamp);


INSERT INTO product (product_name, product_price, product_type, product_create_time, product_modified_time)
VALUES ('huawei-mate9', 6080.01, '手机', current_timestamp, current_timestamp);

INSERT INTO product (product_name, product_price, product_type, product_create_time, product_modified_time)
VALUES ('huawei-mate10', 6080.01, '手机', current_timestamp, current_timestamp);

INSERT INTO product (product_name, product_price, product_type, product_create_time, product_modified_time)
VALUES ('DELL -inspiron5000', 6080.01, '笔记本', current_timestamp, current_timestamp);

INSERT INTO product (product_name, product_price, product_type, product_create_time, product_modified_time)
VALUES ('DELL-inspiron7000', 10080.01, '笔记本', current_timestamp, current_timestamp);

INSERT INTO product (product_name, product_price, product_type, product_create_time, product_modified_time)
VALUES ('DELL-Ware', 16080.01, '笔记本', current_timestamp, current_timestamp);

INSERT INTO product (product_name, product_price, product_type, product_create_time, product_modified_time)
VALUES ('deli', 8.00, '笔记本', current_timestamp, current_timestamp);

INSERT INTO product (product_name, product_price, product_type, product_create_time, product_modified_time)
VALUES ('apple', 8.00, '显示器', current_timestamp, current_timestamp);


SELECT *
FROM product;

# 查询所有的手机

SELECT product_name
FROM product
WHERE product_type = '手机' AND product_price > 5000;

# 模糊查询   LIKE    %  任意多个字符  通过 _代表单个字符

SELECT product_name
FROM product
WHERE product_type = '手机' AND product_name LIKE '%iphone%';

# 排序   order by  desc  降序  asc 升序

SELECT
  product_name,
  product_price
FROM product
ORDER BY product_price ASC;
#  查询不同的内容

SELECT   DISTINCT product_type  FROM  product;

# 分页     limit  n,m   n：从第n个开始向后查   m：查询的个
SELECT   *  FROM   product  LIMIT 6, 3;

# 多表联查



INSERT  INTO  address(customer_id, province, city, country, road, address_lable, address_create_time, address_modified_time)
    VALUES (1,'上海','上海市','徐汇区','曹东之路95号','公司',current_timestamp,current_timestamp);


INSERT  INTO  address(customer_id, province, city, country, road, address_lable, address_create_time, address_modified_time)
VALUES (1,'上海','上海市','浦东新区','东靖路','家里',current_timestamp,current_timestamp);
INSERT  INTO  address(customer_id, province, city, country, road, address_lable, address_create_time, address_modified_time)
VALUES (3,'上海','上海市','浦东新区','东靖路','公司',current_timestamp,current_timestamp);



SELECT   customer_name,province,city,country,road,address_lable
FROM address,customer  WHERE  customer_name='xiaohuang'
 AND   address.customer_id=customer.id;

# 增加订单项   增加订单子项

# 查询指定用户的订单





#  查询所有的用户和用户匹配的地址



















