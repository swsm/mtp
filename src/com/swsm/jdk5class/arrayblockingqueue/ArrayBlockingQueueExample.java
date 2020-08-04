package com.swsm.jdk5class.arrayblockingqueue;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class ArrayBlockingQueueExample {

    public static void main(String[] args) {
        final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep((long) Math.random() * 100000);
                        System.out.println(Thread.currentThread().getName() + "要放一个元素到队列中去");
                        queue.put(UUID.randomUUID().toString());
                        System.out.println(Thread.currentThread().getName() + "已经放一个元素到队列中去了"
                                + "，队列目前有" + queue.size() + "个数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        }
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep((long) Math.random() * 100000);
                    System.out.println(Thread.currentThread().getName() + "要从队列中取一个元素");
                    String data = queue.poll();
                    System.out.println(Thread.currentThread().getName() + "已经取了一个元素" + data
                            + "，队列目前有" + queue.size() + "个数据");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
    
}
