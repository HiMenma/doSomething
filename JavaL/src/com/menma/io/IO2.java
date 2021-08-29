package com.menma.io;

import java.io.FileOutputStream;

public class IO2 {
    public static void main(String[] args) throws Exception{
        //创建文件输出流
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Menma\\Desktop\\bbb.txt", true);
        //写入文件
        fos.write(97);
        fos.write('h');
        String s = "hello~~";
        fos.write(s.getBytes());
        fos.close();
        System.out.println("输出完毕！");

    }
}
