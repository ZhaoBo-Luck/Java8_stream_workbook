package com.zhaobo.stream.disruptor.event;

import lombok.Data;

/**
 * LongEvent.java
 *
 * <p>
 * Description: 向RingBuffer中插入事件元素，在对象中放一个Long变量
 * CreatBy: ZhaoBo (zhaobo@shanshu.ai)
 * Date: 2021/4/15 - 下午5:46
 * </p>
 */
@Data
public class LongEvent {

    private long value;

}
