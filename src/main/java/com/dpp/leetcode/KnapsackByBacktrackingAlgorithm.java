package com.dpp.leetcode;

/**
 * @author dpp
 * @date 2024/8/9
 * @Description 回溯算法解决 0-1背包问题
 */
public class KnapsackByBacktrackingAlgorithm {


    private static int MAX_PRICE = Integer.MIN_VALUE;

    private static int WEIGHT = Integer.MIN_VALUE;

    /**
     * @param i      i表示考察到哪个物品了；
     * @param cw     cw表示当前已经装进去的物品的重量和；
     * @param weight items表示每个物品的重量
     * @param n      n表示物品个数
     * @param m      w背包重量
     */
    public static void f(int i, int cw, int maxPrice, int[] weight, int[] price, int n, int m) {
        //物品都计算完成或总重量等于背包容量时，退出
        if (i == n || cw == m) {
            if (maxPrice > MAX_PRICE) {
                WEIGHT = cw;
                MAX_PRICE = maxPrice;
            }
            return;
        }
        //当前物品不装入背包时，计算可装入的总重量
        f(i + 1, cw, maxPrice, weight, price, n, m);
        if (cw + weight[i] <= m) {
            //当前物品装入背包 cw+weight[i]，计算可装入的价值
            f(i + 1, cw + weight[i], maxPrice + price[i], weight, price, n, m);
        }

    }

    public static void main(String[] args) {
        int[] weight = {12, 2, 1, 1, 4}; // 物品重量kg
        int[] price = {4, 2, 2, 1, 10};  // 物品价值
        int m = 15; // 背包=包容量 kg
        int n = weight.length; // 物品个数

        f(0, 0, 0, weight, price, n, m);

        System.out.println("背包可装物品的总价值最大是 = " + MAX_PRICE+", 总重量= " + WEIGHT + "kg");
    }
}
