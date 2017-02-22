package com.boboface.thread.local;

/**
 * Created by zwb on 2017/2/17.线程范围内共享数据练习
 * 设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1
 */
public class ThreadShareDataExercise {
    public static void main(String[] args) {
        final ShareData shareData = new ShareData();
        //方式1
        new Thread(new MyRunnable1(shareData)).start();
        new Thread(new MyRunnable2(shareData)).start();
        //方式2
        new Thread(new Runnable() {
            @Override
            public void run() {
                shareData.increment();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                shareData.decrement();
            }
        }).start();
    }
}

class MyRunnable1 implements Runnable {
    private ShareData shareData;

    public MyRunnable1(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        shareData.increment();
    }
}

class MyRunnable2 implements Runnable {
    private ShareData shareData;

    public MyRunnable2(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        shareData.decrement();
    }
}

class ShareData {
    private int j = 0;

    //j+1
    public synchronized void increment() {
        j++;
        System.out.println(j);
    }

    //j-1
    public synchronized void decrement() {
        j--;
        System.out.println(j);
    }
}
