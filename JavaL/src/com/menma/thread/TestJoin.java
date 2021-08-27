package com.menma.thread;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程执行中。。。"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread tJ = new Thread(testJoin);
        Thread t = new Thread(testJoin);
//        tJ.setPriority(Thread.MAX_PRIORITY); //设置线程优先级
//        tJ.setPriority(Thread.MIN_PRIORITY);
//        tJ.setPriority(Thread.NORM_PRIORITY);
//        tJ.setDaemon(true);  //设置成守护线程
//        t.setName("11");  //设置代理名称
//        t.getName();    //获取代理名称
//        t.isAlive();    //判断线程是否结束
//        Thread.currentThread(); //表示当前线程

        tJ.start();

        for (int i = 0; i < 10; i++) {
            if (i==5){
                System.out.println("遇到了子线程，让子线程先执行。。。。");
                tJ.join();           //让主线程进入阻塞，，等待子线程执行完毕
            }
            System.out.println("主线程执行中---"+i);
        }
    }

    public synchronized void test(){}
}
