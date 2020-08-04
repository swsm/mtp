package com.swsm.basic;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author swsm
 * @date 2020/8/3
 */
public class TimerScheduleExample {

    //一个每隔2秒输出 一个每隔4秒输出
    static int count = 0;
    
    public static void main(String[] args) {
        class MyTimerTask extends TimerTask {
            @Override
            public void run() {
                count = (count + 1) % 2;
                System.out.println("Thread-1: " + Thread.currentThread().getName());
                new Timer().schedule(new MyTimerTask(), 2000 + 2000 * count);
            }
        };
        new Timer().schedule(new MyTimerTask(), 2000);

        System.out.println("i am main");

        
    }
    
}
