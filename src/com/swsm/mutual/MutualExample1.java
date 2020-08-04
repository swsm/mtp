package com.swsm.mutual;

/**
 * 主线程打印100次子线程打印10次然后主线程再走然后子线程再走走50个轮回
 * 
 * 结论：互斥不是写在线程上的，是写在线程需要访问的资源内部的
 * @author swsm
 * @date 2020/8/3
 */
public class MutualExample1 {

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

    public synchronized void main() throws InterruptedException {
        while (bShouldSub) {
            for (int i = 0; i < 100; i++) {
                System.out.println("main thread sequence of " + (i + 1));
            }
            bShouldSub = false;
            this.notify();
        }
        this.wait();

    }

    public synchronized void sub() throws InterruptedException {
        while (!bShouldSub) {
            for (int i = 0; i < 10; i++) {
                System.out.println("sub thread sequence of " + (i + 1));
            }
            bShouldSub = true;
            this.notify();
        }
        this.wait();

    }
}
