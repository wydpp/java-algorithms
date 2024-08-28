package com.dpp.leetcode.dynamic;

/**
 * @author dpp
 * @date 2024/8/28
 * @Description 动态规划解决 0-1 背包问题
 */
public class ZeroOneBackpack {
    //背包能装地最大重量
    private int maxW = Integer.MIN_VALUE;
    //物品重量
    private int[] weight;
    //物品数量
    private int num;
    //背包容量
    private int backPackCapacity;
    //二维数组，记录每种状态地结果
    private int[][] memo;
    //优化版本，不需要二位数组了
    private boolean[] states;

    ZeroOneBackpack(int[] weight, int num, int backPackCapacity) {
        this.weight = weight;
        this.num = num;
        this.backPackCapacity = backPackCapacity;
        memo = new int[num][backPackCapacity + 1];
        states = new boolean[backPackCapacity + 1];
    }

    public void solve() {
        //从第一个物品开始计算
        //第一个物品不放入
        memo[0][0] = 1;
        //第一个物品放入
        //第一个物品的重量
        int w = weight[0];
        if (weight[0] <= backPackCapacity) {
            memo[0][w] = 1;
        }
        //放入后面的物品
        for (int i = 1; i < num; i++) {
            int cw = weight[i];
            //物品i不放入的情况
            for (int j = 0; j <= backPackCapacity; j++) {
                if (memo[i - 1][j] == 1) {
                    memo[i][j] = memo[i - 1][j];
                }
            }
            //物品i放入的情况,判断物品总量是否超重
            for (int j = 0; j <= backPackCapacity - cw; j++) {
                if (memo[i - 1][j] != 0) {
                    memo[i][j + cw] = 1;
                }
            }
        }
        //计算结果
        for (int i = backPackCapacity; i >= 0; i--) {
            if (memo[num - 1][i] == 1) {
                maxW = i;
                break;
            }
        }
    }

    public void solve2() {
        //从第一个物品开始计算
        //第一个物品不放入
        states[0] = true;
        //第一个物品放入
        //第一个物品的重量
        int w = weight[0];
        if (1 <= backPackCapacity) {
            states[w] = true;
        }
        //放入后面的物品
        for (int i = 1; i < num; i++) {
            int cw = weight[i];
            //物品i不放入的情况-不需要处理了
            //物品i放入的情况,判断物品总量是否超重
            for (int j = backPackCapacity - cw; j > 0; j--) {
                if (states[j]) {
                    states[j + cw] = true;
                }
            }
        }
        //计算结果
        for (int i = backPackCapacity; i >= 0; i--) {
            if (states[i]) {
                maxW = i;
                break;
            }
        }
    }

    public static void main(String[] args) {
        ZeroOneBackpack zeroOneBackpack = new ZeroOneBackpack(new int[]{2, 2, 4, 6, 3}, 5, 9);
        //zeroOneBackpack.solve();
        zeroOneBackpack.solve2();
        System.out.println("背包可装入物品最大重量=" + zeroOneBackpack.maxW);
        //背包可装入物品最大重量=9
    }

}
