package com.swsm.jdk5class;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class CyclicBarrierExample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final CyclicBarrier cb = new CyclicBarrier(3);
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合地点1:当前已有" + (cb.getNumberWaiting() + 1) + "已经到达,正在等候");
                        cb.await();
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合地点2:当前已有" + (cb.getNumberWaiting() + 1) + "已经到达,正在等候");
                        cb.await();
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("线程" + Thread.currentThread().getName() + "即将到达集合地点3:当前已有" + (cb.getNumberWaiting() + 1) + "已经到达,正在等候");
                        cb.await();
                        System.exit(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }
    }
    
    
}
