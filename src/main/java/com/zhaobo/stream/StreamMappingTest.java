package com.zhaobo.stream;

import com.zhaobo.stream.entity.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @CreatBy Luck-ZhaoBo
 * @Date 2021/4/6 - 下午2:41
 */
public class StreamMappingTest {

    private static List<Student> list = Arrays.asList(
            new Student("小明","北京东城" ,18,"男"),
            new Student("小华","北京西城" ,33,"女"),
            new Student("小白","北京南城" ,22,"女"),
            new Student("小黑","北京北城" ,44,"男"),
            new Student("小王","北京外城" ,24,"男"),
            new Student("小牛","北京昌平城" ,13,"女")
    );

    public static void main(String[] args) {

        list.stream().map(Student::getAddress).forEach(System.out::println);
        System.out.println("=============>>>=================");
        list.stream().map(Student::getName).forEach(System.out::println);
        System.out.println("=============>>>=================");
        list.stream().mapToDouble(Student::getAge).forEach(System.out::println);
    }
}
