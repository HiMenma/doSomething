package com.menma.thread;

public class Study_Runnable_ShareRes implements Runnable{
    //Runnable资源共享测试
    int tickets = 10;
    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(1000);    //模拟网络延时对数据造成的影响
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (tickets<0){break;}
            System.out.println(Thread.currentThread().getName()+"--->"+tickets--);
        }


    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        //一份资源
        Study_Runnable_ShareRes srr = new Study_Runnable_ShareRes();
        //多个代理
        new Thread(srr,"srr1").start();
        new Thread(srr,"srr2").start();
        new Thread(srr,"srr3").start();

    }
}
