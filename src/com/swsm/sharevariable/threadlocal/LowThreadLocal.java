package com.swsm.sharevariable.threadlocal;

import java.util.Random;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class LowThreadLocal {

    private static ThreadLocal<Integer> x = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            //Thread.sleep(1000);
            new Thread(() -> {
                int data = new Random().nextInt();
                System.out.println(Thread.currentThread().getName() + " has put data = " + data);
                x.set(data);
                new A().get();
                new B().get();
            }).start();
        }
    }

    static class A {
        public void get() {
            System.out.println("A from " + Thread.currentThread().getName() + " get data = " + x.get());
        }
    }

    static class B {
        public void get() {
            System.out.println("B from " + Thread.currentThread().getName() + " get data = " + x.get());
        }
    }
    
}
