package com.boboface.thread.traditional;

/**
 * Created by zwb on 2017/2/17.传统线程
 */
public class TraditionalThread {
    public static void main(String[] args) {
        //使用方式1
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                //do something
                System.out.println("thread1,子类继承方式的run()方法");
            }
        };
        thread1.start();

        //使用方式2(更符合面向对象编程思想)
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //do something
                System.out.println("thread2,构造方法的参数方式的run()方法");
            }
        });
        thread2.start();

        //思考,使用构造方法的参数方式，与子类继承的方式同时使用，则线程最终执行哪一个?
        //会使用构造方法的参数方式的run()方法，因父类的run()方法会判断runnable是否为空，如果不会空则执行runnable的run()方法
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                //do something
                System.out.println("thread3,子类继承方式的run()方法");
            }
        }) {
            @Override
            public void run() {
                //do something
                System.out.println("thread3,构造方法的参数方式的run()方法");
            }
        };
        thread3.start();
    }
}
