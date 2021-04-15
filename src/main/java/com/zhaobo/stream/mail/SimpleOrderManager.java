package com.zhaobo.stream.mail;

import com.zhaobo.stream.mail.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * SpringMailTest.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/13 - 下午12:15
 * </p>
 */
@Component
public class SimpleOrderManager implements OrderManager{

    @Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;


    @Override
    public void placeOrder(Order order) {

        SimpleMailMessage msg = new SimpleMailMessage(this.simpleMailMessage);
        msg.setTo(order.getCustomer().getEmailAddress());
        msg.setText("Dear " + order.getCustomer().getFirstName()
                + order.getCustomer().getLastName()
                + ", thank you for placing order. Your order number is "
                + order.getOrderNumber());

        try {
            this.mailSender.send(msg);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}
