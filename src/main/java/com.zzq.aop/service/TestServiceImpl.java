package com.zzq.aop.service;

public class TestServiceImpl implements ITestService{

    @Override
    public void sendMessage() {
        System.out.println("TestServiceImpl sendMessage ");
    }
}
