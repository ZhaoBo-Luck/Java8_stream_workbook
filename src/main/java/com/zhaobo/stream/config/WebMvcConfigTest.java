package com.zhaobo.stream.config;

import com.zhaobo.stream.interceptors.InterceptorCustomTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigTest.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/13 - 下午3:55
 * </p>
 */
@Configuration
public class WebMvcConfigTest implements WebMvcConfigurer {


    @Autowired
    private InterceptorCustomTest interceptorCustomTest;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(interceptorCustomTest)
                .addPathPatterns("/**");
    }

}
