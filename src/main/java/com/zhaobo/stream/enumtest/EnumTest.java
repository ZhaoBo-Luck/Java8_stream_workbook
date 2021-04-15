package com.zhaobo.stream.enumtest;

/**
 * EnumTest.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/9 - 上午10:59
 * </p>
 */

public enum EnumTest {

    TEST01("小明","北京"),
    TEST02("小王","南京"),
    TEST03("小张","东京"),
    TEST04("小王","西京");

    private String name;

    private String address;

    EnumTest(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
