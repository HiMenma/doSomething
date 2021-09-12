package com.menma.test;

public class Test {
    public String t1(){
        return "t1";
    }
    public String t1(int i){
        int a = i;
        String s = a + "";
        String s1 = String.valueOf(a);
        Integer ii= new Integer(a);
        String s2 = ii.toString();
        String s3 = Integer.toString(a);
        return "int i t1";
    }

    public String t1(String s,int i){
        return "String s,int i t1";
    }

    public String t1(int i,String s){
        return "1111";
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.t1());
        System.out.println(test.t1(1));
        System.out.println(test.t1(1, "hah"));
        System.out.println(test.t1("ss", 22));

    }

}
