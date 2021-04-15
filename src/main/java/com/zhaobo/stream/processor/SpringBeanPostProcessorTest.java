package com.zhaobo.stream.processor;

import com.zhaobo.stream.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * SpringBeanPostProcessorTest.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/8 - 上午10:13
 * </p>
 */
@Component
@Slf4j
public class SpringBeanPostProcessorTest implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof Student) {

            log.info(">>>>>>>beanName:{}>>>>>>>>>", beanName);

            Student student = (Student) bean;
            student.setAddress("北京市昌平区");
            student.setAge(18);
            student.setName("小明");
            student.setSex("男");
        }

        return bean;
    }
}
