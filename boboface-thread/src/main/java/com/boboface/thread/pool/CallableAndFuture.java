package com.boboface.thread.pool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zwb on 2017/2/17.线程运行结果
 */
public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();//单一线程
        //使用executorService.submit()方法传入callable接口重写call方法，返回future对象
        Future<String> future = executorService1.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello";
            }
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //提交一组callable
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService2);
        for (int i = 1; i <= 10; i++) {
            final int seq = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));
                    return seq;
                }
            });
        }

        for (int i = 1; i <= 10; i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
