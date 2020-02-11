package com.zzq.aop.context;

import com.zzq.aop.aspect.Aspect;
import com.zzq.aop.invocationhandler.AopInvocationHandler;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContextImpl implements ApplicationContext{


    private Aspect aspect;

    public ApplicationContextImpl(Aspect aspect) {
        this.aspect = aspect;
    }

    public final Map<String,Class<?>> beanDefinition = new HashMap<>();

    @Override
    public Object getBean(String beanName) throws Exception{
        Object bean = null;

        bean = createBeanInstance(beanName);
        // 判断是否要AOP增强 如果要 则不能返回原始对象  AOP原理
        if (null != this.aspect && bean.getClass().getName().matches(this.aspect.getPointcut().getClassPattern())) {
            bean = proxyEnhance(bean);
        }
        return bean;
    }

    private Object proxyEnhance(Object bean) {
        return Proxy.newProxyInstance(bean.getClass().getClassLoader(),bean.getClass().getInterfaces(),new AopInvocationHandler(aspect,bean));
    }

    private Object createBeanInstance(String beanName) throws Exception{
        return this.beanDefinition.get(beanName).newInstance();
    }


    @Override
    public void registerBeanDefinition(String beanName, Class<?> clz) {
        this.beanDefinition.put(beanName,clz);
    }
}
