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
        int i = 0,j = 0,index = 0;
        for (; i < m && j < n;index++) {
            int v1 = nums1[i];
            int v2 = nums2[j];
            if (v1 < v2){
                r[index] = v1;
                i++;
            }else{
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
        int[] nums1 = {0,3,9};
        int[] nums2 = {1,8};
        int [] merged = mergeSort(nums1,nums2);
        for(int i=0;i<merged.length;i++){
            System.out.print(merged[i]+",");
        }
    }
}
