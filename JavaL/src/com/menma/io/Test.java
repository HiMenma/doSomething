package com.menma.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
//        System.out.println(scanner());
        System.out.println(scanner2());
    }

    public static String scanner(){
        System.out.println("请输入内容，回车结束：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        return s;
    }

    public static String scanner2() throws IOException {
        System.out.println("请输入内容，回车结束：");
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String s1 = s.readLine();
        s.close();
        return s1;
    }
}
