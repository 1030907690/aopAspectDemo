package com.zzq.aop.invocationhandler;

import com.zzq.aop.advice.Advice;
import com.zzq.aop.aspect.Aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AopInvocationHandler implements InvocationHandler {

    private Aspect aspect;
    private Object target;

    public AopInvocationHandler(Aspect aspect, Object target) {
        this.aspect = aspect;
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //增强逻辑
        //判断方法是否要增强
        if(method.getName().matches(aspect.getPointcut().getMethodPattern())){
            return this.aspect.getAdvice().invoke(target,method,args);
        }
        //不需要代理
        return method.invoke(target,args);
    }
}
