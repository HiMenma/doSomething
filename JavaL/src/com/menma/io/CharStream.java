package com.menma.io;

import java.io.FileReader;
import java.io.FileWriter;

public class CharStream {
    public static void main(String[] args) throws Exception{
        //普通的字符流
        //字符流：对字符进行操作；不能复制图片或二进制文件，使用字节流可以复制任意文件
        //新建写入流 和 读取流
        FileWriter fw = new FileWriter("C:\\Users\\Menma\\Desktop\\CharS.txt");
        FileReader fr = new FileReader("C:\\Users\\Menma\\Desktop\\CharS.txt");
        //写和读
        for (int i = 0; i < 10; i++) {
            fw.write("Hello World!\r\n");
        }
       fw.close();
        System.out.println("写完毕！");
        int read =0;
        char[] buf = new char[1024];
        while ((read=fr.read(buf))!=-1){
            System.out.println(new String(buf,0,read));
        }
        fr.close();
    }
}
