package com.zhaobo.test;

import com.zhaobo.stream.StreamApplication;
import com.zhaobo.stream.mail.SimpleOrderManager;
import com.zhaobo.stream.mail.entity.Customer;
import com.zhaobo.stream.mail.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TestConfigurationProperties.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/13 - 下午2:57
 * </p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StreamApplication.class})
public class TestConfigurationProperties {

    @Autowired
    private Customer customer;

    @Autowired
    private SimpleOrderManager simpleOrderManager;

    @Test
    public void demo() {
        System.err.println(customer);
    }

    @Test
    public void demo02() {
        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderNumber("1433437590459071095");
        simpleOrderManager.placeOrder(order);
    }

}
