package com.swsm.sharevariable.threadlocal;

import java.util.Random;

/**
 * @author swsm
 * @date 2020/8/4
 */
public class GoodThreadLocal {

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                int data = new Random().nextInt();
                System.out.println(Thread.currentThread().getName() + " has put data = " + data);
                MyThreadScopeData.getThreadInstance().setAge(data);
                MyThreadScopeData.getThreadInstance().setName("name" + data);
                new A().get();
                new B().get();
            }).start();
        }
    }

    static class A {
        public void get() {
            System.out.println("A from " + Thread.currentThread().getName() + " get data = " + MyThreadScopeData.getThreadInstance());
        }
    }

    static class B {
        public void get() {
            System.out.println("B from " + Thread.currentThread().getName() + " get data = " + MyThreadScopeData.getThreadInstance());
        }
    }
    
}

class MyThreadScopeData {
    private MyThreadScopeData() {}
    private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<>();
    public static MyThreadScopeData getThreadInstance() {
        MyThreadScopeData instance = map.get();
        if (instance == null) {
            instance = new MyThreadScopeData();
            map.set(instance);
        }
        return instance;
    }

    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "MyThreadScopeData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
