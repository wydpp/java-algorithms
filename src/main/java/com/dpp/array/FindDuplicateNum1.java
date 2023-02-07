package com.dpp.array;

import java.util.HashSet;

/**
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2，3，1，0，2，5，3}，那么对应的输出是重复的数字2或者3。
 * 返回-1表示没有重复的数
 */
public class FindDuplicateNum1 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findNum1(arr));
        System.out.println(findNum2(arr));
    }

    /**
     * 算法1-使用hash表，O(1)复杂度
     *
     * @param arr
     * @return
     */
    private static int findNum1(int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return -1;
        }
        HashSet<Integer> numSet = new HashSet<>(length);
        for (int v : arr) {
            if (numSet.contains(v)) {
                return v;
            } else {
                numSet.add(v);
            }
        }
        return -1;
    }

    /**
     * 不使用额外存储，O(1)复杂度
     * 数组中的数字都在0~n-1的范围内，如果这个数组中没有重复的数字，那么当数组排序之后数字i将出现在下标为i的位置。
     * @return
     */
    public static int findNum2(int[] arr) {
        if (arr == null) {
            return -1;
        }
        if (arr.length < 2) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            while (num != i){
                if (num == arr[num]){
                    return num;
                }else {
                    arr[i] = arr[num];
                    arr[num] = num;
                    num = arr[i];
                }
            }
        }
        return -1;
    }
}
