package com.zzq.aop.advice;

import java.lang.reflect.Method;

public class TimeCsAdvice implements Advice{

    @Override
    public Object invoke(Object target, Method method, Object[] args) throws Exception {
        long sTime = System.currentTimeMillis();
        System.out.println("程序开始执行时间 : "+ sTime);
        Object ret = method.invoke(target,args);
        long useTime = System.currentTimeMillis() - sTime;
        System.out.print("记录 "+ target.getClass().getName() + "." + method.getName() + "耗时:" + (useTime/1000) + "秒");
        return ret;
    }
}
