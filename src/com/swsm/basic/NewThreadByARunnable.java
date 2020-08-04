package com.swsm.basic;

/**
 * @author swsm
 * @date 2020/8/3
 */
public class NewThreadByARunnable {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
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
        });
        t.start();
        System.out.println("i am main");
        // run就是普通的方法
        t.run();
    }
    
}
