package com.swsm.jdk5class.exchange;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class ExchangeExample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Exchanger<String> exchanger = new Exchanger<>();
        service.execute(() -> {
            try {
                String data1 = "zxx";
                System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 + "换出去");
                Thread.sleep((long) Math.random() * 10000);
                String data2 = exchanger.exchange(data1);
                System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + data2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        service.execute(() -> {
            try {
                String data1 = "lhm";
                System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + data1 + "换出去");
                Thread.sleep((long) Math.random() * 10000);
                String data2 = exchanger.exchange(data1);
                System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + data2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        service.shutdown();
    }
    
}
