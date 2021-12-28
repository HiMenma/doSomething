package com.menma.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Words {
    //计算一句话 单词的平均长度
    public static void main(String[] args) {
        int total = 0;
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println(str);
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
//            words_num ++;
//            System.out.println(words[i]);
//            System.out.println(words[i].length());
            total += words[i].length();
        }
        System.out.println(total);
        System.out.println(words.length);
        double avg = (double) (total / words.length);
        System.out.println("单词平均长度为：" + avg);
    }
}
