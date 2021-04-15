package com.zhaobo.stream.timer;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * TimerTest.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo (zhaobo@shanshu.ai)
 * Date: 2021/4/15 - 下午12:01
 * </p>
 */
@Slf4j
public class TimerTest {

    public static void main(String[] args) {

        // timer
        Timer timer = new Timer("TIMER-01");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("start:" + TimeUnit.DAYS.toSeconds(System.currentTimeMillis()));
                demo();
                log.info("end:" + TimeUnit.DAYS.toSeconds(System.currentTimeMillis()));
            }
        },3000L);
    }

    public static void demo() {
      log.info("this a timer schedule task...execute...");
    }
}
