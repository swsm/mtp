package com.swsm.jdk5class.lock;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class ReadWriteLockExample {

    public static void main(String[] args) {
        final Queue3 q3 = new Queue3();
        for (int i = 0; i < 3; i++) {
            new Thread() {
                public void run() {
                    while (true) {
                        q3.get();
                    }
                }
            }.start();

            new Thread() {
                public void run() {
                    while (true) {
                        q3.put(new Random().nextInt(10 * 1000));
                    }
                }
            }.start();
        }
    }
    
}

class Queue3 {
    private Object data = null;
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public void get() {
        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " be ready to read");
            Thread.sleep((long)Math.random() * 1000);
            System.out.println(Thread.currentThread().getName() + " have read data: " + this.data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.readLock().unlock();
        }

    }

    public void put(Object data) {
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " be ready to write");
            Thread.sleep((long)Math.random() * 1000);
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " hava write data: " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.writeLock().unlock();
        }
    }
}
