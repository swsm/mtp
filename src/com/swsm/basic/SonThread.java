package com.swsm.basic;

/**
 * @author swsm
 * @date 2020/8/3
 */
public class SonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread-1" + Thread.currentThread().getName());
                }
            }
        };
        thread.start();
        System.out.println("i am main");
    }
}
