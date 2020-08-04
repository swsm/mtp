package com.swsm.jdk5class.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class ScheduledThreadPool {

    public static void main(String[] args) {
        //定时器线程池 
        //6s 后执行
        Executors.newScheduledThreadPool(3).schedule(() -> {
            System.out.println("bombing!");
        }, 6,  TimeUnit.SECONDS );
        //6s后执行 接下来每隔2s执行
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(() -> {
            System.out.println("bombing!");
        }, 6, 2,  TimeUnit.SECONDS );
    }
    
}
