package com.menma.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BufferedIO {
    public static void main(String[] args) throws Exception{
        //使用带缓冲的io
        //先创建基础的io，再创建带缓存的
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Menma\\Desktop\\buffer.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        //写入数据
        for (int i = 0; i < 100; i++) {
            bos.write("hello~".getBytes(StandardCharsets.UTF_8));  //将数据写入缓冲区，默认8k
            bos.flush(); //刷新缓冲区，将数据写入到硬盘
        }
        //关闭
        bos.close(); //关闭时也自动 flush
        System.out.println("写入完毕！！");
        //读取文件
        //创建输入流
        FileInputStream fis = new FileInputStream("C:\\Users\\Menma\\Desktop\\buffer.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        //读取文件
        int data = 0;
        while ((data=bis.read()) != -1){   //使用自带缓存读取
            System.out.print((char)data);
        }
        System.out.println("读取完毕");
        bis.close();
    }
}
