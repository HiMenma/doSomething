package com.menma.io;

import java.io.Serializable;

public class Student implements Serializable {  //标记可以序列化implements Serializable
    private String name;
    private int age;
    private static transient int i = 0; //使用transient(瞬时的)修饰属性，这个属性就不能序列化
                                        //静态属性不能序列化
    private static final long  serialVersionUID=1L; // 序列化版本号，保证序列化的类和反序列化的类是同一个类
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
