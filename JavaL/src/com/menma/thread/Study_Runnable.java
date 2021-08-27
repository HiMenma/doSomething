package com.menma.thread;

public class Study_Runnable implements Runnable{
    @Override
    public void run() {
        System.out.println("这是Runnable接口的run方法！");
    }

    public static void main(String[] args) {
        Study_Runnable sr1 = new Study_Runnable();
        Thread t1 = new Thread(sr1);
        t1.start();

        new Thread(new Study_Runnable()).start();  //对象只调用一次可以使用匿名对象
    }
}
