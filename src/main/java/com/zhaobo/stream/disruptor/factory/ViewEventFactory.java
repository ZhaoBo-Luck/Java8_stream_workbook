package com.zhaobo.stream.disruptor.factory;

import com.lmax.disruptor.EventFactory;
import com.zhaobo.stream.disruptor.event.ViewHandleEvent;

/**
 * ViewEventFactory.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo (zhaobo@shanshu.ai)
 * Date: 2021/4/16 - 上午11:04
 * </p>
 */
public class ViewEventFactory implements EventFactory<ViewHandleEvent> {

    @Override
    public ViewHandleEvent newInstance() {
        return null;
    }
}
