package com.menma.io;

import java.io.FileInputStream;

public class IO1 {
    public static void main(String[] args) throws Exception{
        //创建输入流
        FileInputStream fis = new FileInputStream("C:\\Users\\Menma\\Desktop\\aaa.txt");
        FileInputStream fis2 = new FileInputStream("C:\\Users\\Menma\\Desktop\\aaa.txt");
        //单字节读取
        int data = 0;
        while ((data = fis.read()) != -1){
//            System.out.print((char) data);
        }
        fis.close();
        //多字节读取
        int count = 0;
        byte[] buf = new byte[3];  //缓冲大小为3
//        int read = fis2.read(buf);
        while ((count=fis2.read(buf)) != -1){
            System.out.println(new String(buf,0,count));  //把字节数组buf，从0取到count长度
        }
        fis2.close();
    }
}
