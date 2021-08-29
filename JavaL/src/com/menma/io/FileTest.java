package com.menma.io;
/*
* File类的使用
* 1.分隔符
* 2.文件操作
* 3.文件夹操作
**/

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) throws Exception{
//        seperator();
//        fileOpen();
        dirOpe();
    }
    //文件路径的分割符
    public static void seperator(){
        System.out.println("路径分隔符："+ File.pathSeparator);
        System.out.println("名称分隔符："+File.separator);
    }
    //文件操作
    public static void fileOpen() throws Exception {
        //1.创建文件
        File file = new File("C:\\Users\\Menma\\Desktop\\file.txt");
        if(!file.exists()){  //若文件不存在
            boolean b = file.createNewFile(); //创建文件
            System.out.println("创建文件成功！");
        }
        //2.删除文件
        if(false){
            //2.1 直接删除
        file.delete();
            //2.2 jvm退出时删除
        file.deleteOnExit();
        Thread.sleep(5000);
        System.out.println("删除成功！");
        }
        //3.获取文件信息
        System.out.println("绝对路径："+file.getAbsolutePath());
        System.out.println("路径："+file.getPath());
        System.out.println("文件名："+file.getName());
        System.out.println("文件父级目录："+file.getParent());
        System.out.println("文件长度："+file.length());
        System.out.println("文件创建时间："+new Date(file.lastModified()));
        System.out.println("-------------------------------");
        //4.判断
        System.out.println("文件是否可写："+file.canWrite());
        System.out.println("是否是文件："+file.isFile());
        System.out.println("是否是隐藏的："+file.isHidden());
    }
    //文件夹操作
    public static void dirOpe() throws Exception{
        //1.创建文件夹
        File dir = new File("C:\\Users\\Menma\\Desktop\\DDD\\GGG");
        System.out.println("文件夹名字："+dir.toString());
        if(!dir.exists()) {  //若文件夹不存在
//        dir.mkdir();  //创建单级文件夹
            dir.mkdirs(); //创建多级目录
            System.out.println("多级文件夹创建成功~");
        }
        //2.删除文件夹 ： 文件夹必须为空才能删除
        if(false){
            //        2.1直接删除
            dir.delete(); //只能删除最底层文件夹
//        2.2 jvms删除
            dir.deleteOnExit();
            Thread.sleep(3000); //线程退出三秒后删除
            System.out.println("删除成功！");
        }
        System.out.println("--------------------");
        //3.获取文件夹信息
        System.out.println(dir.getAbsolutePath());
        System.out.println(dir.getPath());
        System.out.println(dir.getParent());
        System.out.println(dir.getName());
        System.out.println(dir.length());
        System.out.println(new Date(dir.lastModified()));
        System.out.println("--------------------");
        //判断
        System.out.println("是不是文件"+dir.isFile());
        System.out.println("是不是文件夹"+dir.isDirectory());
        System.out.println(dir.isHidden());
        System.out.println("--------------------");
        //5.遍历文件夹:只是当前文件夹
        File dir2 = new File("C:\\Users\\Menma\\Desktop\\H");
        String[] dirList = dir2.list();
        System.out.println("H文件夹中有:");
        for (String l :
                dirList) {
            System.out.println(l);
        }
        System.out.println("--------------------");
        //FileFilter接口的使用
        File[] files = dir2.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().endsWith(".ppt"))  //只返回以.ppt后缀的文件
                    return true;
                return false;
            }
        });
        System.out.println("以.ppt后缀的文件有：");
        for (File file:
             files) {
            System.out.println(file.getName());
        }
    }
}
