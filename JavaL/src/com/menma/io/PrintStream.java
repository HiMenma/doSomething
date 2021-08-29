package com.menma.io;

import java.io.PrintWriter;

public class PrintStream {
    public static void main(String[] args) throws Exception{
        //打印流:支持数据原样打印;封装了print() / println() 方法 支持写入后换行
        //创建
        PrintWriter pw = new PrintWriter("C:\\Users\\Menma\\Desktop\\print.txt");
        //打印
        pw.println(123);
        pw.println(true);
        pw.println("hi~");
        pw.println(3.15);
        pw.println('u');
        //关闭
        pw.close();
    }
}
