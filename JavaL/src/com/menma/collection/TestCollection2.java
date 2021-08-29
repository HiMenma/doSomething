package com.menma.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestCollection2 {
    public static void main(String[] args) {
        Student s1 = new Student("张三", 19);
        Student s2 =  new Student("李四",10);
        Student s3 =  new Student("王二",559);
        Collection alist = new ArrayList();
        //增
        alist.add(s1);
        alist.add(s2);
        alist.add(s3);
        System.out.println(alist);
        //删
        alist.remove(s1);
        System.out.println("删除s1后："+alist);
        System.out.println("删除s1后size："+alist.size());
        System.out.println("----------------------");
        //for遍历
        for (Object obj :
                alist) {
            Student s = (Student)obj;
            System.out.println(s.toString());
//            System.out.println(obj.toString());
        }
        System.out.println("----------------------");
        //迭代遍历
        Iterator it = alist.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("----------------------");
        alist.clear();
        System.out.println("清空alist的大小："+alist.size());

    }
}
