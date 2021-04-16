package com.zhaobo.stream.scheduling;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * SpringScheduleTest.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/13 - 上午11:50
 * </p>
 */
//@Component
public class SpringScheduleTest {


    /*@Scheduled(cron = "0 57 11 * * ?")
    public void testSchedule() {

        System.err.println("this a spring schedule job......");
    }*/

    /*@Scheduled(fixedRate = 5000L)
    public void testSchedule1() {
        System.err.println("this a spring schedule job......");
    }*/

    @Scheduled(cron = "*/5 * * * * ?")
    public void testSchedule1() {
        System.err.println("this a spring schedule job......");
    }

    @Async
    public void testAsync() {
        System.err.println("you can do something here ....");
    }
}
