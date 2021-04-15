package com.zhaobo.stream.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TransactionFactoryBean.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo (zhaobo@shanshu.ai)
 * Date: 2021/4/14 - 下午3:48
 * </p>
 */
@Slf4j
public class TransactionFactoryBean implements FactoryBean, InvocationHandler {

    private ClassLoader classLoader;

    private String ClassName;

    public TransactionFactoryBean(ClassLoader classLoader, String className) {
        this.classLoader = classLoader;
        ClassName = className;
    }

    @Override
    public Object getObject() throws Exception {
       return Proxy.newProxyInstance(classLoader,new Class[]{getObjectType()},this);
    }

    @Override
    public Class<?> getObjectType() {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(ClassName, false, classLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (log.isInfoEnabled()) {
            log.info("execute method : {}",method.getName());
        }
        System.err.println("hello fantastic baby ... ");
        Class<?> methodDeclaringClass = method.getDeclaringClass();
        log.info("methodDeclaringClass:{}",methodDeclaringClass);
        return null;
    }
}
