package com.swsm.mutual;

/**
 * @author swsm
 * @date 2020/8/3
 */
public class MutualBySynchronized {

    public static void main(String[] args) {
        MutualBySynchronized mutual = new MutualBySynchronized();
        mutual.init();
        
    }


    private void init() {
        OutPut2 outPut = new OutPut2();
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
    
}

class OutPut2 {
    public synchronized void outPut(String name) {
        int length = name.length();
        for (int i = 0; i < length; i++) {
            System.out.print(name.charAt(i));
        }
        System.out.println();
    }
}
