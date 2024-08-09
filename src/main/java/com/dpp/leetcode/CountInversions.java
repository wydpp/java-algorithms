package com.dpp.leetcode;

/**
 * @author dpp
 * @date 2024/8/8
 * @Description 求解逆序对数量算法
 */
public class CountInversions {

    public static int countInversions(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int temp[] = new int[arr.length];
        return mergeSortCount(arr, temp, 0, arr.length - 1);
    }

    private static int mergeSortCount(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int count = 0;
        int mid = left + (right - left) / 2;
        count += mergeSortCount(arr, temp, left, mid);
        count += mergeSortCount(arr, temp, mid + 1, right);
        count += mergeCount(arr, temp, left, mid, right);
        return count;
    }

    private static int mergeCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        int count = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                //如果arr[i] > arr[j],则 arr[i]到arr[mid]的数据都大于a[j],所以逆序对个数此时= mid-i +1
                count += (mid - i + 1);
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int m = left; m <= right; m++) {
            arr[m] = temp[m];
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 3, 1, 5, 6};
        int inversions = countInversions(arr);
        System.out.println("Inversion count: " + inversions);
    }


}
