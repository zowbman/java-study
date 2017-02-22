package com.boboface.thread.local;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by zwb on 2017/2/17.线程范围内共享数据(原理)
 * 把数据与线程放置一个map里面，获取根据线程获取数据，达到线程内共享数据
 */
public class ThreadScopeShareData {
    private static int data = 0;
    private static Map<Thread, Integer> threadData = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data:" + data);
                    threadData.put(Thread.currentThread(), data);
                    new A().getA();
                    new B().getB();
                }
            }).start();
        }
    }

    static class A {
        public void getA() {
            int data = threadData.get(Thread.currentThread());
            System.out.println("A from " + Thread.currentThread().getName() + " get data:" + data);
        }
    }

    static class B {
        public void getB() {
            int data = threadData.get(Thread.currentThread());
            System.out.println("B from " + Thread.currentThread().getName() + " get data:" + data);
        }
    }
}
