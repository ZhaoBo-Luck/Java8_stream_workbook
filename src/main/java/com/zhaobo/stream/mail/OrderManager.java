package com.zhaobo.stream.mail;

import com.zhaobo.stream.mail.entity.Order;

/**
 * OrderManager.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/13 - 下午12:23
 * </p>
 */
public interface OrderManager {

    void placeOrder(Order order);
}
