package com.swsm.basic;

/**
 * @author swsm
 * @date 2020/8/3
 */
public class BasicThread {

    public static void main(String[] args) {
        //lambda方式创建线程
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " say i am wangxiaoer");
            }
        }).start();
        System.out.println("i am main");
        
    }
    
}
