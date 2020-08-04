package com.swsm.jdk5class.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class FixedThreadPool {

    public static void main(String[] args) {
        //固定的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //缓存线程池
        //ExecutorService threadPool = Executors.newCachedThreadPool();
        //一个线程的线程池但如果该线程挂了会自动再启动一个
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int task = i;
            threadPool.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + " is loop of " + j + " for task of " + task);
                }
            });
        }
    }
    
}
