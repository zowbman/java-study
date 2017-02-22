package com.boboface.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zwb on 2017/2/21.锁 替换synchronized
 */
public class LockDemo {
    public static void main(String[] args) {
        final OutPuter outPuter = new OutPuter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outPuter.outPut("zhangweibao");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                outPuter.outPut("doublezhang");
            }
        }).start();
    }

    static class OutPuter {
        Lock lock = new ReentrantLock();

        public void outPut(String name) {
            if (!"".equals(name)) {
                int len = name.length();
                lock.lock();
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
                lock.unlock();
            }
        }
    }
}
