package com.dpp.sort;

import java.util.Arrays;

/**
 * @author dpp
 * @date 2024/6/19
 * @Description 快速排序算法
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int p = partition(arr,left,right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        //arr[left,i-1]表示已经处理过的区间，arr[i+1,right]是未处理的区间
        //i表示最后pivot的位置
        int i = left;
        int j = left;
        for (; j < right; j++) {
            if (arr[j] < pivot) {
                //小于pivot的移动到arr[left,i-1]区间尾部位置i处
                swap(arr, i, j);
                i++;
            }
        }
        //pivot插入到位置i
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 6, 5};
        quickSort(nums);
        //[1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(nums));
    }
}
