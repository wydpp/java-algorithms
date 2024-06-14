package com.dpp.merge;

import java.util.Arrays;

/**
 * 归并算法
 *
 * @author wydpp
 */
public class MergeSort {

    public static int[] mergeSort(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] r = new int[m + n];
        int i = 0, j = 0, index = 0;
        for (; i < m && j < n; index++) {
            int v1 = nums1[i];
            int v2 = nums2[j];
            if (v1 < v2) {
                r[index] = v1;
                i++;
            } else {
                r[index] = v2;
                j++;
            }
        }
        if (i < m) {
            for (int o = 0; i < m; i++, o++) {
                r[index + o] = nums1[i];
            }
        }
        if (j < n) {
            for (int o = 0; j < n; j++, o++) {
                r[index + o] = nums2[j];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 2, 8, 0, 0};
        int[] nums2 = {1, 4};
        merge(nums1, 3, nums2, 2);
        System.out.println(Arrays.toString(nums1));

        int[] nums = {0,1,2,2,3,0,4,2};
        int k = removeElement(nums,2);
        System.out.printf("k="+k);
        System.out.printf(Arrays.toString(nums));
    }

    /**
     * 给你两个按非递减顺序排列的整数数组nums1和nums2，另有两个整数m和n，分表表示nums1和nums2中的元素数组。
     * 请你合并nums2到nums1中，是合并后的数组同样按非递减顺序排列。
     * <p>
     * 合并后的数组不应由函数返回，而是存储在数组nums1中。为了应对这种情况，nums1的输出长度为m+n，其中前m个元素表示应合并的元素，后n的个元素为0，应忽略。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    //逆向双指针算法
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int k = 0;
        int[] result = new int[length];
        for (int i = 0, j = 0; i < length; i++) {
            int value = nums[i];
            if (value == val) {
                k++;
            } else {
                result[j] = value;
                j++;
            }
        }
        for (int i=0;i<length-k;i++){
            nums[i]=result[i];
        }
        return k;
    }
}
