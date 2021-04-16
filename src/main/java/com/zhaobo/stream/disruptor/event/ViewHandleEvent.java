package com.zhaobo.stream.disruptor.event;

import lombok.Data;

import java.util.Map;

/**
 * ViewHandleEvent.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo (zhaobo@shanshu.ai)
 * Date: 2021/4/16 - 上午10:54
 * </p>
 */

@Data
public abstract class ViewHandleEvent {

    private String cmd;

    private Map<String,Object> args;


 }
