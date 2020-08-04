package com.swsm.mutual;

/**
 * @author swsm
 * @date 2020/8/3
 */
public class NoMutual {

    public static void main(String[] args) {
        NoMutual noMutual = new NoMutual();
        noMutual.init();
        
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
    
}

class OutPut {
    public void outPut(String name) {
        int length = name.length();
        for (int i = 0; i < length; i++) {
            System.out.print(name.charAt(i));
        }
        System.out.println();
    }
}
