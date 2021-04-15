package com.zhaobo.test;

import com.zhaobo.stream.entity.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @CreatBy Luck-ZhaoBo
 * @Date 2021/4/6 - 下午2:48
 */
public class StreamTest {

    List<Student> list = Arrays.asList(
            new Student("小明", "北京东城", 18, "男"),
            new Student("小华", "北京西城", 33, "女"),
            new Student("小白", "北京南城", 22, "女"),
            new Student("小白", "北京南城", 22, "女"),
            new Student("小黑", "北京北城", 44, "男"),
            new Student("小王", "北京外城", 24, "男"),
            new Student("小牛", "北京昌平城", 13, "女")
    );


    /**
     * stream排序
     */
    @Test
    public void demo1() {

        // 自然排序
        list.stream().sorted((x, y) -> {
            if (x.getAge().equals(y.getAge())) {
                return x.getName().compareTo(y.getName());
            } else {
                return x.getAge().compareTo(y.getAge());
            }
        }).forEach(System.out::println);

    }

    /**
     * 去重练习
     */
    @Test
    public void demo2() {

        String[] arr = {"aaa","bbb","bbb","vvv","ccc","ddd","ccc","vvv"};
        List strS = Arrays.asList(arr);
        strS.stream().distinct().forEach(System.out::println);
    }

    /**
     *  计算平均数
     */
    @Test
    public void demo3() {
        Double avg = list.stream().collect(Collectors.averagingInt(Student::getAge));
        System.out.println(avg);
    }

    /**
     * 求和
     */
    @Test
    public void demo4() {
//        IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(Student::getAge));
        Integer collect = list.stream().collect(Collectors.summingInt(Student::getAge));
        System.out.println(collect);
    }

    /**
     * 最小值
     */
    @Test
    public void demo5() {
        Optional<Student> collect = list.stream().collect(Collectors.minBy((x, y) -> x.getAge().compareTo(y.getAge())));
        System.out.println(collect);
    }

    /**
     * 最大值
     */
    @Test
    public void demo6() {
        Optional<Student> collect = list.stream().max(Comparator.comparing(Student::getAge));
        Student student = collect.get();
        System.out.println(collect);
        System.out.println(student.getAge());

        Runnable runnable = () -> {

            System.out.println("runnable ....");
            int i = 0;
            i++;
        };
        list.forEach(System.out::println);
       new Thread(runnable).start();
    }

    /**
     * 计数
     */
    @Test
    public void demo07() {
        long count = list.stream().filter(student -> student.getSex().equals("男")).count();
        System.out.println(count);

        long count1 = list.parallelStream().filter(student -> student.getAge() > 18).count();
        System.out.println(count1);

        long 男 = list.parallelStream().filter(student -> student.getSex().equals("男")).count();
        System.out.println(男);
    }





}
