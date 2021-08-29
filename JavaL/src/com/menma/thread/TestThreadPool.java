package com.menma.thread;

import java.util.concurrent.*;

public class TestThreadPool {
    public static void main(String[] args) {
        //核心线程数量，最大线程数量，存活时间，时间单位，等待队列大小，线程工厂类型，拒绝策略
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 8; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + "====》在办理业务");
            });
        }
        executorService.shutdown();
    }
}
