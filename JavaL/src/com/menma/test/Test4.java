package com.menma.test;

public class Test4 {

    String ss;
    int ii;

    public static void main(String[] args) {
        StaticInner staticInner = new StaticInner();   //内部类必须定义为static 或者 写在 Test 外面；否则报错:
                                                        // java: 无法从静态上下文中引用非静态 变量 this
                                                        //静态方法中不能使用this关键字,StaticInner属于Test4（this）
        staticInner.display();
        staticInner.s = "aaaa";
        staticInner.i = 1;
        staticInner.display();
        System.out.println("------------");
        Outter outter = new Outter();
        outter.dis();
    }

      static class StaticInner{
        private String s = "yyy";
        private Integer i = 0;
        private boolean b;


        void display(){
            System.out.println(s + i);
        }
    }

     void sayHi(){

        System.out.println();
    }
}

class Outter{
    void dis(){
        System.out.println("this is Outter~");
    }
}

