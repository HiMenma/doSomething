package com.menma.thread;


public class Study_Thread2 extends Thread{
    private Integer num;

    public Study_Thread2(Integer num) {
        this.num = num;
    }

    @Override
    public void run() {
        Tools tools = new Tools();
        //调用工具中的方法
        tools.tool(num);

    }

    public static void main(String[] args) {
        Study_Thread2 st1 = new Study_Thread2(1);
        Study_Thread2 st2 = new Study_Thread2(2);
        Study_Thread2 st3 = new Study_Thread2(3);
        st1.start();
        st2.start();
        st3.start();

    }
}
