package com.dpp.random;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName RefervoirSampling.java
 * @Author duanpengpeng
 * @Version 1.0.0
 * @Description 蓄水池抽样算法
 * @CreateTime 2023/06/26 09:20:00
 */
public class ReservoirSampling {

    /**
     * 假设数据序列的规模为n，需要采样的数量为k。
     * 首先构建一个可容纳k个元素的数组，将序列的前k个元素放入数据中。
     * 然后从第k+1个元素开始，已 k/n的概率来决定该元素是否被替换到数组中（数组中的元素被替换的概率是相同的）。
     * 当遍历完所有元素之后，数组中剩下的元素即为所需的样本。
     */

    public static int[] sampling(int[] pool, int k) {
        int n = pool.length;
        if (n <= k) {
            return pool;
        }
        int[] result = new int[k];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            if (i<k){
                result[i] = pool[i];
            }else {
                int r = random.nextInt(i+1);
                if (r < k){
                    result[r] = pool[i];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 100;
        int k = 5;
        int[] pool = new int[n];
        for (int i =0;i<n;i++){
            pool[i] = i;
        }
        System.out.println(Arrays.toString(sampling(pool, k)));
    }
}
