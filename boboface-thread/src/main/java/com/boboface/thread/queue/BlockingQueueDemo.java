package com.boboface.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zwb on 2017/2/21.阻塞队列
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        final BlockingQueue queue = new ArrayBlockingQueue(3);
        for (int i = 0 ; i<2;i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                        System.out.println(Thread.currentThread().getName() + "准备放数据,目前队列有" + queue.size() + "个数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
        //因取数据和打印不能保持原子性，所以会出现，取了后但是cpu去了其他线程，导致没有打印
        new Thread(){
            @Override
            public void run() {
                try {
                    //此处睡眠改为100或1000，观察运行结果
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "准备取数据!");
                    queue.take();
                    System.out.println(Thread.currentThread().getName() + "已经取走数据,队列目前有" + queue.size() + "个数据");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
