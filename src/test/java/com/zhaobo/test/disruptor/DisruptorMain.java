package com.zhaobo.test.disruptor;

import javafx.event.EventHandler;

import java.util.concurrent.ThreadFactory;

/**
 * DisruptorMain.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/13 - 上午11:05
 * </p>
 */
public class DisruptorMain {

    public static void main(String[] args) {

        class Element {

            private Integer value;

            public Integer getValue() {
                return value;
            }

            public void setValue(Integer value) {
                this.value = value;
            }
        }

        // 生产者的线程工厂
        ThreadFactory threadFactory = r -> new Thread(r, "simpleThread");

    }
}
