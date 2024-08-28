package com.dpp.leetcode.dynamic;

/**
 * @author dpp
 * @date 2024/8/28
 * @Description 杨辉三角
 * 我们现在对它进行一些改造。每个位置的数字可以随意填写，经过某个数字只能到达下面一层相邻的两个数字。
 * 假设你站在第一层，往下移动，我们把移动到最底层所经过的所有数字之和，定义为路径的长度。请你编程求出从最高层移动到最底层的最短路径长度。
 * <p>
 * 5   *   *   *
 * 7   8   *   *
 * 2   3   4   *
 * 4   9   6   1
 */
public class PascalTriangleByArray {

    /**
     * 找到最短路径长度
     *
     * @return
     */
    public int findShortestPath(int[][] data) {
        if (data == null) {
            return 0;
        }
        int level = data.length;
        //存储每一层往下的最短路径
        int[] min = new int[level + 1];
        //采用倒推计算
        for (int i = level - 1; i >= 0; i--) {
            int[] rawNums = data[i];
            int rowLength = rawNums.length;
            for (int j = 0; j < rowLength; j++) {
                min[j] = Math.min(min[j], min[j + 1]) + rawNums[j];
            }
        }
        return min[0];
    }

    public static void main(String[] args) {
        //使用二维数组构建数据
        int[][] root = new int[][]{{5}, {7, 8}, {2, 3, 4}, {4, 9, 6, 1}};
        PascalTriangleByArray pascalTriangle = new PascalTriangleByArray();
        int shortestPath = pascalTriangle.findShortestPath(root);
        System.out.println("最短路径长度：" + shortestPath);
        //最短路径=:[5, 7, 2, 4]
        //最短路径=:[5, 8, 4, 1]
        //最短路径长度：18
    }
}
