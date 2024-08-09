package com.dpp.leetcode;

/**
 * @author dpp
 * @date 2024/8/9
 * @Description 回溯思想解决“八皇后问题”
 * 我们有一个 8x8 的棋盘，希望往里放 8 个棋子（皇后），每个棋子所在的行、列、对角线都不能有另一个棋子。
 * 我们把这个问题划分成 8 个阶段，依次将 8 个棋子放到第一行、第二行、第三行……第八行。
 * 在放置的过程中，我们不停地检查当前放法，是否满足要求。
 * 如果满足，则跳到下一行继续放置棋子；
 * 如果不满足，那就再换一种放法，继续尝试。
 */
public class EightQueue {

    private static final int MAX_QUEEN = 8;
    /**
     * 8x8 的棋盘，下标表示行，值表示queen存储在哪一列 result[0] = 1  表示第一行，第一列
     */
    private static int[] result = new int[MAX_QUEEN];

    public static void cal8queue(int row) {
        if (row == MAX_QUEEN) { // 8个棋子都放置好了，打印结果
            printQueue();
            return;//8行棋子都放好了，已经没法再往下递归了，所以就return
        }
        for (int column = 0; column < MAX_QUEEN; column++) {// 每一行都有8中放法
            if (isOk(row, column)) {    // 有些放法不满足要求
                result[row] = column;   // 第row行的棋子放到了column列
                cal8queue(row + 1);// 考察下一行
            }
        }
    }

    private static boolean isOk(int row, int column) {//判断row行column列放置是否合适
        int leftColumn = column - 1;
        int rightColumn = column + 1;
        for (int i = row - 1; i >= 0; i--) {// 逐行往上考察每一行
            if (result[i] == column) {// 第i行的column列有棋子吗？
                return false;
            }
            if (leftColumn >= 0 && result[i] == leftColumn) {// 考察左上对角线：第i行leftup列有棋子吗？
                return false;
            }
            if (rightColumn < MAX_QUEEN && result[i] == rightColumn) {// 考察右上对角线：第i行rightup列有棋子吗？
                return false;
            }
            leftColumn--;
            rightColumn++;
        }
        return true;
    }

    private static void printQueue() {
        for (int row = 0; row < MAX_QUEEN; row++) {
            for (int column = 0; column < MAX_QUEEN; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-------------------------------------------");
    }


    public static void main(String[] args) {
        //92个解
        cal8queue(0);
    }

}
