CREATE TABLE IF NOT EXISTS `t_order_item%s` (
  `id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_id` BIGINT (20) NOT NULL COMMENT '订单ID',
  `user_id` BIGINT (20) NOT NULL COMMENT '用户ID',
  `brand_name` VARCHAR (56) NOT NULL COMMENT 'brandName',
  `product_name` VARCHAR (56) NOT NULL COMMENT 'productName',
  `order_date` VARCHAR (32) NOT NULL COMMENT 'orderDate',
  `pay_date` VARCHAR (32) NOT NULL COMMENT 'payDate',
  `total_price` FLOAT NOT NULL COMMENT 'totalPrice',
  `pay_discount` INT (11) NOT NULL DEFAULT '0' COMMENT 'payDiscount',
  `pay_price` FLOAT NOT NULL COMMENT 'payPrice',
  PRIMARY KEY (`id`, `pay_discount`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4