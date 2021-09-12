package com.menma.test;


public class Test2 {
    class Inner{
        /**
         * java 8中，内部类的变量不允许用staic什么；除非是静态类。
         * */
        int i;
//        static int b = 1;
        private int a = 0;
    }
    static class Inner2{
        int i;
        static int b = 1;
        private int a = 0;
    }
}
