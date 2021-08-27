package com.menma.thread;

public class ThreadTerninate implements Runnable{

    private Boolean flag = true;
    private String name;

    public ThreadTerninate(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag){
//            for (int i = 0; i < 100; i++) {
//                if (i==88){terminate();}
//                System.out.println(name+"---"+i);
//            }
            System.out.println(name+"---"+i++);
        }
    }

    public void terminate(){   // 控制线程标识
        this.flag=false;
    }

    public static void main(String[] args) {
//        new Thread(new ThreadTerninate("线程1")).start();
        ThreadTerninate tt = new ThreadTerninate("线程1");
        new Thread(tt).start();
        for (int i = 0; i < 100; i++) {
            if(i==88){
                tt.terminate();
                System.out.println("线程终止。。。");
            }
            System.out.println("main--->"+i);
        }
    }
}
