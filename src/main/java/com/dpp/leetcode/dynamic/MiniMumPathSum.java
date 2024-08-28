package com.dpp.leetcode.dynamic;

/**
 * @author dpp
 * @date 2024/8/28
 * @Description 假设我们有一个 n 乘以 n 的矩阵 w[n][n]。
 * 矩阵存储的都是正整数。棋子起始位置在左上角，终止位置在右下角。我们将棋子从左上角移动到右下角。
 * 每次只能向右或者向下移动一位。从左上角到右下角，会有很多不同的路径可以走。
 * 我们把每条路径经过的数字加起来看作路径的长度。那从左上角移动到右下角的最短路径长度是多少呢？
 */
public class MiniMumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
        //从起点1走到终点3的最短路径长度
        System.out.println(minPathSum(grid));
    }

    private static boolean minPathSum(int[][] grid) {
        // write your code here
        return false;
    }
}
