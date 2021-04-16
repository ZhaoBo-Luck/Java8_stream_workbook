package com.zhaobo.stream.disruptor.quarts;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.zhaobo.stream.disruptor.event.LongEvent;
import com.zhaobo.stream.disruptor.factory.LongEventFactory;
import com.zhaobo.stream.disruptor.handler.LongEventHandler;
import net.bytebuddy.utility.RandomString;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * EventPublishSchedule.java
 *
 * <p>
 * Description: 事件发布定时任务
 * CreatBy: ZhaoBo (zhaobo@shanshu.ai)
 * Date: 2021/4/15 - 下午6:25
 * </p>
 */
@Component
public class EventPublishSchedule {

    @Scheduled(cron = "*/10 * * * * ?")
    public void publicEvent() {

        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10, r -> {
            int i = 0;
            return new Thread(r,"pool-1-thread-" + (++i));
        });

        // 事件生产工厂
        LongEventFactory longEventFactory = new LongEventFactory();

        // RingBuffer的大小
        int bufferSize = 256;

        // 实例化Disruptor对象，初始化RingBuffer
        Disruptor<LongEvent> longEventDisruptor =
                new Disruptor<LongEvent>(longEventFactory,bufferSize,executorService, ProducerType.SINGLE,new BlockingWaitStrategy());

        // 设置事件的执行者，单消费者，
        longEventDisruptor.handleEventsWith(new LongEventHandler());

        //disruptor启动：
        longEventDisruptor.start();

        RingBuffer<LongEvent> ringBuffer = longEventDisruptor.getRingBuffer();

        // 设置事件生产者，每隔十秒发布一个事件
        for(int i = 0;i < bufferSize;i++) {
            // 获取下一个可用位置的下标
            long sequence = ringBuffer.next();
            try{
                // 返回可用位置的元素
                LongEvent event = ringBuffer.get(sequence);
                // 设置该位置元素的值
                event.setValue(i);
            }finally{
                // 发布事件
                ringBuffer.publish(sequence);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
