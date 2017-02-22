package com.boboface.thread.local;

import java.util.Random;

/**
 * Created by zwb on 2017/2/17.线程内共享数据,ThreadLocal的使用
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> dataInt = new ThreadLocal<>();//简单类型
    private static ThreadLocal<MyThreadScopeData> dataPo = new ThreadLocal<>();//po

    public static void main(String[] args) {
        //两个线程共享一份数据
        for (int i = 1; i <= 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //简单类型
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data:" + data);
                    dataInt.set(data);
                    //包装类型
                    MyThreadScopeData myThreadScopeData = MyThreadScopeData.getInstance();
                    myThreadScopeData.setName("zhangweibao");
                    myThreadScopeData.setAge(24);
                    System.out.println(Thread.currentThread().getName() + " has put data:" + myThreadScopeData.toString());
                }
            }).start();
        }
    }

    static class A {
        public void getA() {
            int data = dataInt.get();
            System.out.println("A from " + Thread.currentThread().getName() + " get data:" + data);
            MyThreadScopeData myThreadScopeData = MyThreadScopeData.getInstance();
            System.out.println("A from " + Thread.currentThread().getName() + "get data:" + myThreadScopeData.toString());
        }
    }

    static class B {
        public void getB() {
            int data = dataInt.get();
            System.out.println("B from " + Thread.currentThread().getName() + " get data:" + data);
            MyThreadScopeData myThreadScopeData = MyThreadScopeData.getInstance();
            System.out.println("B from " + Thread.currentThread().getName() + "get data:" + myThreadScopeData.toString());
        }
    }
}

//外部类，使用单例模式
class MyThreadScopeData {

    private MyThreadScopeData() {//把构造方法私有化
    }

    private static ThreadLocal<MyThreadScopeData> threadLocal = new ThreadLocal<>();

    public static /*synchronized*/ MyThreadScopeData getInstance() {//不需要互斥也行
        MyThreadScopeData instance = threadLocal.get();
        if (instance == null) {
            instance = new MyThreadScopeData();
            threadLocal.set(instance);
        }
        return instance;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  this.name + "|" + this.age;
    }
}
