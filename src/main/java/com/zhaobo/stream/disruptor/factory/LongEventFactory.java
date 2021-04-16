package com.zhaobo.stream.disruptor.factory;

import com.lmax.disruptor.EventFactory;
import com.zhaobo.stream.disruptor.event.LongEvent;

/**
 * LongEventFactory.java
 *
 * <p>
 * Description: 事件生产工厂：生产事件存入RingBuffer中
 * CreatBy: ZhaoBo (zhaobo@shanshu.ai)
 * Date: 2021/4/15 - 下午5:48
 * </p>
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
