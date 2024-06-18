package com.dpp.sort;

import java.util.Arrays;

/**
 * @author dpp
 * @date 2024/6/18
 * @Description 冒泡排序
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 6, 5};
        bubbleSort(nums);
        //[1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(nums));
    }
}
