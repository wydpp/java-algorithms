package com.dpp.sort;

import java.util.Arrays;

/**
 * @author dpp
 * @date 2024/6/18
 * @Description 插入排序
 */
public class InsertionSort {
    /**
     * 插入排序：包含两种操作，一种是元素的比较，一种是元素的移动
     * 当我们需要将一个数据a插入到已排序区间时，需要拿a与已排序区间的元素一次比较大小，找到合适的插入位置。
     * 找到插入点之后，还需要将插入点之后的元素顺序往后移动一位，才能腾出位置给元素a插入。
     * 1.取未排序的一个元素，和已排序的元素比较，如果小于已排序元素，则已排序元素移动一次。
     * 2.如果大于等于已排序元素，则停止比较，找到了要插入的位置，直接插入即可
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        if ((arr == null || arr.length <= 1)) {
            return;
        }
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    //移动数据
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            //插入数据
            arr[j + 1] = value;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 6, 5};
        insertionSort(nums);
        //[1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(nums));
    }
}
