package com.zzq.aop.pointcut;

public class Pointcut {


    public Pointcut(String classPattern, String methodPattern) {
        this.classPattern = classPattern;
        this.methodPattern = methodPattern;
    }

    private String classPattern;

    private String methodPattern;

    public String getClassPattern() {
        return classPattern;
    }

    public void setClassPattern(String classPattern) {
        this.classPattern = classPattern;
    }

    public String getMethodPattern() {
        return methodPattern;
    }

    public void setMethodPattern(String methodPattern) {
        this.methodPattern = methodPattern;
    }
}
