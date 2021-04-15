package com.zhaobo.stream.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * BeanFactoryRegistrar.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/8 - 上午10:36
 * </p>
 */
@Component
@Slf4j
public class BeanFactoryRegistrar implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware, BeanClassLoaderAware {


    private static final String FACTORY_PATH = "META-INF/transaction.factories";

    private ClassLoader classLoader;

    private ApplicationContext applicationContext;

    private Map<Object, Object> classNames = new HashMap<Object, Object>();

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {

        loadFactories();

        Set<Map.Entry<Object, Object>> entries = this.classNames.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            String beanName = (String) entry.getKey();
            String beanClass = (String) entry.getValue();

            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(TransactionFactoryBean.class);
            ConstructorArgumentValues constructorArgumentValues = beanDefinition.getConstructorArgumentValues();
            constructorArgumentValues.addIndexedArgumentValue(0,classLoader);
            constructorArgumentValues.addIndexedArgumentValue(1,beanClass);
            beanDefinitionRegistry.registerBeanDefinition(beanName,beanDefinition);
        }
    }

    private void loadFactories() {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(FACTORY_PATH);
        Properties properties = new Properties();
        try {
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
            }

            Set<Object> keys = properties.keySet();
            for (Object key : keys) {
                classNames.put(key,properties.get(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) configurableListableBeanFactory;
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        List<String> list = Arrays.asList(beanDefinitionNames);
        for (String s : list) {
            if (log.isInfoEnabled()) {
                log.info("beanDefinitionNames:{}",s);
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

}
