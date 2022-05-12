package com.dpp.leetcode;

import com.dpp.merge.MergeSort;

/**
 * @author wydpp
 */
public class FindMedianSortedArrays {
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
     * 采用归并排序，得到新数组后取中位数
     * 算法的时间复杂度应该为 O(m+n) 。
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //归并算法得到新数组
        int[] nums = MergeSort.mergeSort(nums1,nums2);
        int length = nums.length;
        int middle = length/2;
        if (length%2 == 0){
            return ((double) nums[middle-1]+(double) nums[middle])/2;
        }else {
            return nums[middle];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
