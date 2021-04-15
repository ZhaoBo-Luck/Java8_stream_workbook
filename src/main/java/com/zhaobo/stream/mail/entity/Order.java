package com.zhaobo.stream.mail.entity;

import lombok.Data;

/**
 * Order.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/13 - 下午2:25
 * </p>
 */
@Data
public class Order {

    private Customer customer;

    private String orderNumber;
}
