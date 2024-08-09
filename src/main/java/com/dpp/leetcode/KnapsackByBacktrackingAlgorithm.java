package com.dpp.leetcode;

/**
 * @author dpp
 * @date 2024/8/9
 * @Description 回溯算法解决 0-1背包问题
 */
public class KnapsackByBacktrackingAlgorithm {


    private static int maxW = Integer.MIN_VALUE;

    private static int[] bestx;

    /**
     * @param i      i表示考察到哪个物品了；
     * @param cw     cw表示当前已经装进去的物品的重量和；
     * @param weight items表示每个物品的重量
     * @param n      n表示物品个数
     * @param m      w背包重量
     */
    public static void f(int i, int cw, int[] weight, int n, int m) {
        //物品都计算完成或总重量等于背包容量时，退出
        if (i == n || cw == m) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        //当前物品不装入背包时，计算可装入的总重量
        f(i + 1, cw, weight, n, m);
        if (cw + weight[i] <= m) {
            //当前物品装入背包 cw+weight[i]，计算可装入的总重量
            f(i + 1, cw + weight[i], weight, n, m);
        }

    }

    public static void main(String[] args) {
        int[] weight = {25, 40, 30, 20}; // 物品重量
        int m = 100; // 背包=包容量
        int n = weight.length; // 物品个数

        f(0, 0, weight, n, m);

        System.out.println(maxW);
    }
}
