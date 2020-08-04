package com.swsm.basic;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author swsm
 * @date 2020/8/3
 */
public class TimerSchedule {

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Thread-1" + Thread.currentThread().getName());
            }
        }, 2000, 1000);
    }
    
}
