package com.menma.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PicCopy {
    public static void main(String[] args) throws Exception {
        //创建输入输出流
        FileInputStream fis = new FileInputStream("C:\\Users\\Menma\\Desktop\\2.jpg");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Menma\\Desktop\\3.jpg");
        //边读边写
        byte[] buf = new byte[99999];
        int count = 0;
        while ((count=fis.read(buf)) != -1){
            fos.write(buf,0,count);
        }
        System.out.println("复制成功！");
        //关闭流
        fis.close();
        fos.close();
    }
}
