package com.dpp.sort;

import java.util.Arrays;

/**
 * @author dpp
 * @date 2024/6/20
 * @Description 使用快排思想解决问题：使用O(n)时间复杂度求无序数组中的第K大的元素
 * 比如：[4,2,5,12,3],第3大的元素是4.（第1大元素，表示最大的元素）
 *
 */
public class QuickSortScene1 {

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }
        int n = nums.length;
        return quickSort(nums, 0, n - 1, n - k);
    }

    private static int quickSort(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return nums[k];
        }
        int pivot = partition(nums, left, right);
        if (pivot == k) {
            return nums[k];
        } else if (pivot < k) {
            return quickSort(nums, pivot + 1, right, k);
        } else {
            return quickSort(nums, left, pivot - 1, k);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        int j = left;
        for (; j < right; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int right) {
        int tmp = nums[i];
        nums[i] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 6, 5};
        int kthLargest = findKthLargest(nums, 2);//5
        System.out.println(Arrays.toString(nums));
        System.out.println(kthLargest);
    }
}
