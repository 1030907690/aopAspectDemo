package com.zzq.aop.context;

public interface ApplicationContext {

    Object getBean(String beanName)throws Exception;

    void registerBeanDefinition(String beanName,Class<?> clz);
}
