package com.menma.thread;

public class Lambda {
    public static void main(String[] args) {
        new Thread(
                ()-> System.out.println("lambda表达式的使用。。")
        ).start();
    }
}
