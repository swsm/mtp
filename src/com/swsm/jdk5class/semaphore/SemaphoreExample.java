package com.swsm.jdk5class.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class SemaphoreExample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore sp = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            Runnable runnabel = new Runnable() {
                @Override
                public void run() {
                    try {
                        sp.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "进入,当前已有" +
                            (3 - sp.availablePermits()) + "个信号灯被用！");
                    try {
                        long sleepNum = new Random().nextInt(10);
                        System.out.println("线程：" + Thread.currentThread().getName() + "将睡眠" + sleepNum + "秒");
                        Thread.sleep(sleepNum * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    };
                    System.out.println("线程" + Thread.currentThread().getName() + "即将离开");
                    sp.release();
                }
            };
            service.submit(runnabel);
        }
    }
    
}
