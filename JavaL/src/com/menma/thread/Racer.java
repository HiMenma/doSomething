package com.menma.thread;

public class Racer implements Runnable{
    private String winner;
    @Override
    public void run() {
        for(int step=1;step<=100;step++){
            //模拟乌龟休息
            if(Thread.currentThread().getName().equals("乌龟") && step%10 == 0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName()+"-->"+step);
            boolean flag = gameOver(step);
            if(flag){
                break;
            }

        }
    }

    private boolean gameOver(int step){
        if (winner !=null){ //若存在胜利者
            return true;
        }else {
            if(step == 100){
                winner = Thread.currentThread().getName();
                System.out.println("冠军是："+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer,"兔子").start();
        new Thread(racer,"乌龟").start();
    }
}
