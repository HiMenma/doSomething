package com.menma.thread;

public class TestYield {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("线程1--------"+i);

            }
        }).start();


        for (int i = 0; i < 100; i++) {
            if(i%10==0){
                Thread.yield(); //主线程礼让
            }
            System.out.println("main-->"+i);
        }
    }
}
