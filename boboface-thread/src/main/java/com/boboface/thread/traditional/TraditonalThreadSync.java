package com.boboface.thread.traditional;

/**
 * Created by zwb on 2017/2/17.传统线程互斥
 * 例子：如银行取钱，通常程序是读取后修改数据再保存，如1000元，当读取后还没有来得及修改以及保存，就有另外一个人进行取钱，取了200，并且成功了
 * 第一个人存了两百1000+200，就1200，显然这样子是不行的
 */
public class TraditonalThreadSync {
    public static void main(String[] args) {
        final OutPuter outPuter = new OutPuter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPuter.output1("zhangweibao");
                    //outPuter.output2("zhangweibao");
                    //outPuter.output3("zhangweibao");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPuter.output1("doublezhang");
                    //outPuter.output2("doublezhang");
                    //outPuter.output3("doublezhang");
                }
            }
        }).start();
    }

    static class OutPuter {
        //1、在需要互斥的代码放进synchronized中
        public void output1(String name) {
            if (!"".equals(name)) {
                int len = name.length();
                synchronized (this) {
                    for (int i = 0; i < len; i++) {
                        System.out.print(name.charAt(i));
                    }
                    System.out.println();
                }
            }
        }

        //2、声明方法用synchronized关键字
        public synchronized void output2(String name) {
            if (!"".equals(name)) {
                int len = name.length();
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }

        //3、当方法为静态方法时，把this换成OutPuter.class，静态方法只能和字节码对象进行关联
        public static void output3(String name) {
            if (!"".equals(name)) {
                int len = name.length();
                synchronized (OutPuter.class) {
                    for (int i = 0; i < len; i++) {
                        System.out.print(name.charAt(i));
                    }
                    System.out.println();
                }
            }
        }
    }
}
