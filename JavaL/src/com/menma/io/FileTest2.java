package com.menma.io;

import java.io.File;

public class FileTest2 {
    public static void main(String[] args) {
        //文件夹的递归使用
//        listDir(new File("C:\\Users\\Menma\\Desktop\\H"));
        deleteDir(new File("C:\\Users\\Menma\\Desktop\\H"));
    }
    //递归遍历文件夹
    public static void listDir(File dir){
        File[] files = dir.listFiles();
        System.out.println("此文件夹的绝对路径："+dir.getAbsolutePath());
        if(files != null && files.length>0){
            for (File f :
                    files) {
                if (f.isDirectory()) {
                    listDir(f);  //若是文件夹继续调用，递归
                }else {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
    //递归删除文件夹及文件
    public static void deleteDir(File dir){
        File[] files = dir.listFiles();  //拿到当前目录的内容
        if(files != null && files.length>0){
            for (File f :
                    files) {  //遍历当前目录
                if(f.isDirectory()){  //是文件夹继续递归
                    deleteDir(f);
                }else{   //不是文件夹就删除
                    System.out.println( f.getAbsolutePath()+"删除"+f.delete());
                }
            }
        }
        dir.delete();   //最后删除空的文件夹
        System.out.println("删除成功！");
    }
}
