package com.tzeho.plaza.common.util;

import lombok.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/* @description 获取 Spring Bean
 * @author tzeho */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
    }

    public static <T> T getBean(String name, Class<T> requiredType) { return ac.getBean(name, requiredType); }

}
