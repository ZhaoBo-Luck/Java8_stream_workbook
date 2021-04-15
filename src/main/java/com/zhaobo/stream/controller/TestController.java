package com.zhaobo.stream.controller;

import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class TestController {

    @RequestMapping("/demo")
    public List<String> test() {
        return new ArrayList<String>(){{
            add("呵呵");
            add("哈哈");
            add("嘿嘿");
        }};
    }
}
