package com.boboface.thread.lock;

import com.boboface.thread.traditional.TraditionalThreadExercise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zwb on 2017/2/22.condition与Thread中的wait()和notify()方法一样，但是可以带状态
 */
public class ConditionCommunication {
    public static void main(String[] args) {
        new TraditionalThreadExercise().init();
    }

    public void init() {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //如此循环50次
                for (int i = 1; i <= 50; i++) {
                    business.sub(i);
                }
            }
        }).start();
        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }
    }

    //wait()和notify()必须在synchronized关键字中
    class Business {
        private boolean bShouldSub = true;
        private Lock lock = new ReentrantLock();//锁替换synchronization
        private Condition condition = lock.newCondition();

        //子线程循环10次
        public void sub(int i) {
            lock.lock();
            try {
                while (!bShouldSub) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 1; j <= 10; j++) {
                    System.out.println("sub thread sequece of " + j + ",loop of " + i);
                }
                bShouldSub = false;
                condition.signal();
            } finally {//使用try{}把上锁的代码放进里面，在finally{}中解锁，防止代码执行异常，导致死锁
                lock.unlock();
            }
        }

        //主线程循环100次
        public void main(int i) {
            lock.lock();
            try {
                while (bShouldSub) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 1; j <= 100; j++) {
                    System.out.println("main thread sequece of " + j + ",loop of " + i);
                }
                bShouldSub = true;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
