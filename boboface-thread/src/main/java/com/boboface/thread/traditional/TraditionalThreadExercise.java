package com.boboface.thread.traditional;

/**
 * Created by zwb on 2017/2/17.练习
 * 子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再会到主线程循环100次，如此循环50次
 */
public class TraditionalThreadExercise {
    public static void main(String[] args) {
        new TraditionalThreadExercise().init();
    }

    public void init() {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //循环50次
                for (int i = 1; i <= 50; i++) {
                    business.sub(i);
                }
            }
        }).start();
        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }
    }

    //this.wait()和this.notify()必须在synchronized关键字中
    class Business {
        private boolean bShouldSub = true;

        //子循环10次
        public synchronized void sub(int i) {
            while (!bShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println("子线程(sub thread) sequece of " + j + "，lock of " + i);
            }
            bShouldSub = false;
            this.notify();//唤醒
        }

        //主循环100次
        public synchronized void main(int i) {
            while (bShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 100; j++) {
                System.out.println("主线程(main thread) sequece of " + j + "，lock of " + i);
            }
            bShouldSub = true;
            this.notify();
        }
    }
}
