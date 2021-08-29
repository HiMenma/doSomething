package com.menma.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerializableInput {
    public static void main(String[] args) throws Exception{
        //反序列化，读取对象
        FileInputStream fis = new FileInputStream("C:\\Users\\Menma\\Desktop\\sss.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        //读取，反序列化
//        Student s1 =(Student)ois.readObject();
        ArrayList<Student> list = (ArrayList<Student>) ois.readObject(); //读取多个对象
        //关闭
        ois.close();
//        System.out.println(s1.toString());
        System.out.println(list.toString());

        System.out.println("反序列化结束！");
    }
}
