package com.zzq.aop.aspect;

import com.zzq.aop.advice.Advice;
import com.zzq.aop.pointcut.Pointcut;

public class Aspect {

    private Pointcut pointcut;

    private Advice advice;

    public Aspect(Pointcut pointcut, Advice advice) {
        this.pointcut = pointcut;
        this.advice = advice;
    }

    public Pointcut getPointcut() {
        return pointcut;
    }

    public void setPointcut(Pointcut pointcut) {
        this.pointcut = pointcut;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
