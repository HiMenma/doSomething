package com.menma.test;

public class Test3 {
     //组合 和 继承
    int i = 0;
    String s = "hi~";

    public Test3() {
    }
    public Test3(int i, String s) {
        this.i = i;
        this.s = s;
    }

    void display(){
        System.out.println(s + i);
    }

     public static void main(String[] args) {
         T3 t3 = new T3();  //继承
         t3.display();

         System.out.println("-----------下面是组合---------");
         T4 t4 = new T4();
         t4.test3.display(); //组合
         System.out.println("-----instanceof------");
         if (t3 instanceof Test3){
             System.out.println("t3是Test3的子类对象"+(t3 instanceof Test3));
         }

     }
}

class T3 extends Test3{
    //继承
    Boolean b;
    public T3() {
    }

    public T3(int i, String s,boolean b) {
        super(i, s);   //构造方法重载
        this.b = b;
    }
}

class T4{
    Test3 test3 = new Test3();  //为组合使用准备
}