package com.dpp.random;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName Shuffle.java
 * @Author duanpengpeng
 * @Version 1.0.0
 * @Description 洗牌算法
 * @CreateTime 2023/06/21 16:38:00
 */
public class Shuffle {
    /**
     * 题目：写一个方法,入参为自然数n(n > 0)，返回一个自然数数组，数组长度为n，元素为[1,n]之间，
     * 且每个元素不重复，数组中各元素顺序要求随机；
     * 实例1： 输入: N = 3 输出: 132
     * 实例2： 输入: N = 5 输出: 32514
     */
    public static int[] shuffle(int n) {
        /*
        算法原理：
        1.初始化数组array:[0,1,2...n-1]
        2.循环n次，每次从 [0,n-i) 之间取一个随机数，和第 n-i
         */
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int j = random.nextInt(n - i);
            swap(array, n - i - 1, j);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(10)));
    }

}
