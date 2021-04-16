package com.zhaobo.stream.disruptor.handler;

import com.lmax.disruptor.EventHandler;
import com.zhaobo.stream.disruptor.event.LongEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * LongEventHandler.java
 *
 * <p>
 * Description: 事件处理器
 * CreatBy: ZhaoBo (zhaobo@shanshu.ai)
 * Date: 2021/4/15 - 下午5:52
 * </p>
 */
@Slf4j
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        if (log.isInfoEnabled()) {
            log.info("Event:{}",longEvent.getValue());
        }
    }
}
