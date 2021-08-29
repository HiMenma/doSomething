package com.menma.io;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializableOutput {
    public static void main(String[] args) throws Exception{
        //序列化：将对象通过流进行传输
        //创建流
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Menma\\Desktop\\SSS.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        //开始序列化，写入操作
        Student s1 = new Student("yyy", 22);
        Student s2 = new Student("lll", 22);
        //写多个对象，使用泛型集合
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
//        oos.writeObject(s1);
        oos.writeObject(students);
        // 关闭
        oos.close(); //自带flush
        System.out.println("序列化结束！");
    }
}
