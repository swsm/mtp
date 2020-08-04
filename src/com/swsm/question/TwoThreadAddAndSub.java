package com.swsm.question;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class TwoThreadAddAndSub {

    private int j;
    public static void main(String[] args) {
        TwoThreadAddAndSub m = new TwoThreadAddAndSub();
        Inc inc = m.new Inc();
        Dec dec = m.new Dec();
        for (int i = 0; i < 2; i++) {
            new Thread(inc).start();
            new Thread(dec).start();
        }
    }

    private synchronized void inc() {
        j++;
    }
    private synchronized void dec() {
        j--;
    }

    class Inc implements  Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
                System.out.println("执行加后现在j的值为：" + j);
            }
        }
    }

    class Dec implements  Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
                System.out.println("执行减后现在j的值为：" + j);
            }
        }
    }
    
}
