package com.swsm.jdk5class.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class LockReplaceSynchronized {

    //和上面synchronized 达成相同的效果
    class OutPut {
        Lock lock = new ReentrantLock();
        public void outPut(String name) {
            lock.lock();
            int length = name.length();
            try {
                for (int i = 0; i < length; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            } finally {
                lock.unlock();
            }
        }
    }
    private void init() {
        OutPut outPut = new OutPut();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPut.outPut("zhangsan");
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPut.outPut("wangxiaoer");
                }

            }
        }).start();
    }

    public static void main(String[] args) {
        LockReplaceSynchronized m = new LockReplaceSynchronized();
        m.init();
    }
    
}
