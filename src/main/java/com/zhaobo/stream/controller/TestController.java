package com.zhaobo.stream.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * TestController.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/13 - 下午4:06
 * </p>
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @PostMapping("/algorithm")
    public Result<Boolean> test() {

        try {
            //log.info("param:{}",param);
            log.info("模拟算法开始执行");
            Thread.sleep(15 * 1000);
            log.info("模拟算法执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return Result.success(true);
    }
}
