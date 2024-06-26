package com.dpp.search;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * @author dpp
 * @date 2024/6/24
 * @Description 二分查找算法
 */
public class BinarySearch {
    /**
     * 查找数组中值等于target的一个元素的位置
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找数组中第一个值等于target的元素的位置
     * 比如：arr=[1,3,3,3,3,4,6],target=3,则返回index=1
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchFirstEq(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                if (mid == 0 || arr[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找数组中最后一个值等于target的元素的位置
     * 比如：arr=[1,3,3,3,3,4,6],target=3,则返回index=4
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchLastEq(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                if (mid == arr.length - 1 || arr[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找数组中第一个值大于等于target的元素的位置
     * 比如：arr=[1,3,3,3,3,4,6],target=1,则返回index=1
     * 比如：arr=[1,3,3,3,3,4,6],target=2,则返回index=1
     * 思路：
     * 1.找到最后一个值等于target的元素位置，如果有，则index+1就是第一个；
     * 2.如果没找到等于target的元素，则需要记录下第一次比他大的元素位置
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchFirstGte(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                if (mid == 0 || arr[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找数组中最后一个值小于等于target的元素的位置
     * 比如：arr=[1,3,3,3,3,4,6],target=1,则返回index=0
     * 比如：arr=[1,3,3,3,3,4,6],target=4,则返回index=4
     * 思路：
     *
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearchLastLte(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                if (mid == arr.length - 1 || arr[mid + 1] > target) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static void testFirstEq() {
        int[] arr = {1, 3, 3, 3, 3, 4, 6};
        int index = binarySearchFirstEq(arr, 3);
        System.out.println("Found first target at index: " + index);
    }

    private static void testLastEq() {
        int[] arr = {1, 3, 3, 3, 3, 4, 6};
        int index = binarySearchLastEq(arr, 3);
        System.out.println("Found last target at index: " + index);
    }

    private static void testFirstGte() {
        int[] arr = {1, 3, 3, 3, 3, 4, 6, 6, 10};
        int index = binarySearchFirstGte(arr, 2);
        System.out.println("Found first gte target at index: " + index);
        index = binarySearchFirstGte(arr, 3);
        System.out.println("Found first gte target at index: " + index);
        index = binarySearchFirstGte(arr, 5);
        System.out.println("Found first gte target at index: " + index);
    }

    private static void testLastLte() {
        int[] arr = {1, 3, 3, 3, 3, 4, 6};
        int index = binarySearchLastLte(arr, 3);
        System.out.println("Found last lte 3 at index: " + index);
        index = binarySearchLastLte(arr, 5);
        System.out.println("Found last lte 5 at index: " + index);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = binarySearch(arr, 5);
        System.out.println("Found target at index: " + index);
        testFirstEq();
        testLastEq();
        testFirstGte();
        testLastLte();
    }

}
