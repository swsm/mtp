package com.swsm.sharevariable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class StaticHashMap {

    private static Map<Thread, Integer> threadMap = new HashMap<>();
    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                threadMap.put(Thread.currentThread(), new Random().nextInt());
                System.out.println(Thread.currentThread().getName() + " has put data = " + threadMap.get(Thread.currentThread()).intValue());
                new A().get();
                new B().get();
            }).start();
        }

    }

    static class A {
        public void get() {
            System.out.println("A from " + Thread.currentThread().getName() + " get data = " + threadMap.get(Thread.currentThread()).intValue());
        }
    }

    static class B {
        public void get() {
            System.out.println("B from " + Thread.currentThread().getName() + " get data = " + threadMap.get(Thread.currentThread()).intValue());
        }
    }
    
}
