package com.swsm.jdk5class.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class ExecutorsSubmit {

    //threadPool的submit方法可以返回结果 Future<String> future
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(() -> {
            Thread.sleep(6 * 1000);
            return "hello";
        });
        System.out.println("等待结果：");
        try {
            System.out.println("拿到结果：" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("我先去做其它事情!");
    }
    
}
