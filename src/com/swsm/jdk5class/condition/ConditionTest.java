package com.swsm.jdk5class.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class ConditionTest {

    public static void main(String[] args) throws InterruptedException {
        Business business = new Business();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    business.sub();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        for (int i = 0; i < 50; i++) {
            business.main();
        }
    }
    
}

//注意下面的条件判断用while，不要用if，防止线程被假唤醒(jdk文档有说明)
class Business {
    private boolean bShouldSub = true;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void main() throws InterruptedException {
        lock.lock();
        try {
            while (bShouldSub) {
                try {
                    condition.await();

                } catch (Exception e) {

                }
            }
            for (int i = 0; i < 100; i++) {
                System.out.println("main thread sequence of " + (i + 1));
            }
            bShouldSub = true;
            condition.signal();
        } finally {
            lock.unlock();
        }

    }

    public synchronized void sub() throws InterruptedException {
        lock.lock();
        try {
            while (!bShouldSub) {
                try {
                    condition.await();
                } catch (Exception e) {

                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("sub thread sequence of " + (i + 1));
            }
            bShouldSub = false;
            condition.signal();
        } finally {
            lock.unlock();
        }

    }
}
