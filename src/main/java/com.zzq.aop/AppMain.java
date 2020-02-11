package com.zzq.aop;


import com.zzq.aop.advice.Advice;
import com.zzq.aop.advice.TimeCsAdvice;
import com.zzq.aop.aspect.Aspect;
import com.zzq.aop.context.ApplicationContext;
import com.zzq.aop.context.ApplicationContextImpl;
import com.zzq.aop.pointcut.Pointcut;
import com.zzq.aop.service.ISampleService;
import com.zzq.aop.service.ITestService;
import com.zzq.aop.service.SampleServiceImpl;
import com.zzq.aop.service.TestServiceImpl;

public class AppMain {

    public static void main(String[] args) throws Exception{
        Advice advice = new TimeCsAdvice();
        Pointcut pointcut = new Pointcut("com\\.zzq\\.aop\\.service\\..*",".*Message");
        Aspect aspect = new Aspect(pointcut,advice);
        //用户已给出切面
        //要织入一个切面生效
        //不能让用户自己new对象  应该有一个工厂来负责
        //可以定义不是拿到原始对象  而是拿到被动了手脚的对象(即代理对象)
        //提供一个工厂来创建业务对象 IOC是AOP基石

        //模拟IOC
        ApplicationContext context = new ApplicationContextImpl(aspect);
        context.registerBeanDefinition("sampleServiceImpl", SampleServiceImpl.class);
        context.registerBeanDefinition("testServiceImpl", TestServiceImpl.class);

        ISampleService sampleService = (ISampleService)context.getBean("sampleServiceImpl");
        sampleService.sample();

        ITestService testService = (ITestService)context.getBean("testServiceImpl");
        testService.sendMessage();

    }
}
