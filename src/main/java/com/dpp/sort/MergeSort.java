package com.dpp.sort;

import java.util.Arrays;

/**
 * @author dpp
 * @date 2024/6/18
 * @Description 归并排序，时间复杂度O(nlogn)
 */
public class MergeSort {

    /**
     * 核心思想：如果要排序一个数组，先把数组从中间分成前后两部分，然后对前后两部分分别进行排序，再将排好序的两部分合并再一起。
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归算法递推公式：mergeSort(p...r) = merge(mergeSort(p...q),mergeSort(q+1...r))
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        //此时经过上面的mergeSort处理，arr[left,mid]和arr[mid+1,right]已经分别是有序的了，然后再合并两个有序数组
        merge(arr, left, mid, right);
    }

    /**
     * 合并两个有序数组arr[left,mid]和arr[mid+1,right]
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        //合并后的结果
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 6, 5};
        mergeSort(nums);
        //[1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(nums));
    }

}
