package com.zhaobo.stream;

import com.zhaobo.stream.entity.Student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * StreamApplication.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/7 - 上午10:33
 * </p>
 */
@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy
@MapperScan(basePackages = {"com.zhaobo.stream.dao.mapper"})
public class StreamApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(StreamApplication.class, args);
        Student bean = applicationContext.getBean(Student.class);
        System.out.println(bean);

    }

    @Bean
    public Student student() {
        return new Student();
    }
}
