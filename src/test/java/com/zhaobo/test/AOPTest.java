package com.zhaobo.test;

import com.zhaobo.stream.StreamApplication;
import com.zhaobo.stream.enumtest.EnumTest;
import com.zhaobo.stream.transaction.IService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * AOPTest.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/8 - 下午3:36
 * </p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StreamApplication.class)
@SuppressWarnings("all")
public class AOPTest {

    @Autowired
    IService service;

    @Test
    public void demo01() {
        String name = EnumTest.TEST02.getName();
        System.out.println(name);

        System.out.println(service.getClass().getName());

        service.test();
    }

}
