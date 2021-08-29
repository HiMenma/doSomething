package com.menma.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedCharStream {
    public static void main(String[] args) throws Exception{
        //带缓存的字符流：高效读写，支持输入换行符，可一次读写一行
        //创建写流
        FileWriter fw = new FileWriter("C:\\Users\\Menma\\Desktop\\BufferedCharS.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        //创建读流
        FileReader fr = new FileReader("C:\\Users\\Menma\\Desktop\\BufferedCharS.txt");
        BufferedReader br = new BufferedReader(fr);
        //开始写
        for (int i = 0; i < 10; i++) {
            bw.write("好好学习！");
            bw.newLine(); //换行
        }
        bw.close();
        System.out.println("写入完毕！");
        //开始读
        //1.自定缓存大小
//        char[] buf = new char[1024];
//        int count = 0;
//        while ((count=br.read(buf)) != -1){
//            System.out.println(new String(buf,0,count));
//        }
        //2.使用readLine,一行一行读取
        String line = null;
        while ((line = br.readLine()) != null){  //br.readLine()为null 读取结束
            System.out.println(line);
        }
        br.close();
        System.out.println("读取完毕！");
    }
}
