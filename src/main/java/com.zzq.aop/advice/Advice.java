package com.zzq.aop.advice;

import java.lang.reflect.Method;

public interface Advice {

    public Object invoke(Object target, Method method,Object[] args) throws Exception;
}
