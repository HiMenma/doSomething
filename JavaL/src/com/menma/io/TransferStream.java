package com.menma.io;

import java.io.*;

public class TransferStream {
    public static void main(String[] args) throws Exception{
        //桥转换流：Input
        //转换流：可以将 字节流 转换为 字符流，并设置编码格式；
        //先写，创建输出流
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Menma\\Desktop\\trans.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");//写时指定字符格式
        //写
        for (int i = 0; i < 10; i++) {
            osw.write("我来自中国CN\r\n");
            osw.flush();
        }
        osw.close();
        System.out.println("写完毕");
        //再读
        FileInputStream fis = new FileInputStream("C:\\Users\\Menma\\Desktop\\trans.txt");
        InputStreamReader isr = new InputStreamReader(fis, "gbk");//读时指定对应编码格式
        int data = 0;
        char[] buf = new char[1024];
        while ((data = isr.read(buf)) != -1){
            System.out.println(new String(buf,0,data));
        }
        isr.close();
        System.out.println("读取完毕！");
    }
}
