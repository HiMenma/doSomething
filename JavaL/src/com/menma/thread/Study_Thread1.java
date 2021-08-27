package com.menma.thread;

public class Study_Thread1 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("这是线程1："+ i);
        }
    }

    public static void main(String[] args) {
        Study_Thread1 s1 = new Study_Thread1();
        s1.start(); //开启一个线程
        s1.run(); //只是相当于调用一个普通方法

        int[] nums = {1,2,23,4,5,6};
        for (int x:nums
        ){
            System.out.println("主线程main："+ x);
        }
    }
}
