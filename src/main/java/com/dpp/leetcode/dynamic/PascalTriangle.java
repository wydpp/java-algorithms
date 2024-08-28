package com.dpp.leetcode.dynamic;

import com.dpp.tree.Node;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author dpp
 * @date 2024/8/28
 * @Description 杨辉三角
 * 我们现在对它进行一些改造。每个位置的数字可以随意填写，经过某个数字只能到达下面一层相邻的两个数字。
 * 假设你站在第一层，往下移动，我们把移动到最底层所经过的所有数字之和，定义为路径的长度。请你编程求出从最高层移动到最底层的最短路径长度。
 * 5   *   *   *
 * 7   8   *   *
 * 2   3   4   *
 * 4   9   6   1
 */
public class PascalTriangle {

    private int minPathLength = Integer.MAX_VALUE;

    private int[] result;

    /**
     * 找到最短路径长度
     *
     * @param root
     * @return
     */
    public int findShortestPath(Node root,int totalLevle) {
        if (root == null) {
            return 0;
        }
        result = new int[totalLevle];
        traverse(root, 5, 0);
        return minPathLength;
    }

    /**
     * @param root   链表
     * @param length 当前路径长度
     * @param level  二叉树层数
     */
    private void traverse(Node root, int length, int level) {
        result[level] = root.getData();
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            if (length <=  minPathLength){
                minPathLength = length;
                System.out.println("最短路径=:"+Arrays.toString(result));
            }
            return;
        }
        //走左边子节点
        traverse(root.getLeftChild(), length + root.getLeftChild().getData(), level + 1);
        //走右边子节点
        traverse(root.getRightChild(), length + root.getRightChild().getData(), level + 1);
    }

    public static void main(String[] args) {
        //使用链表构架一个二叉树
        Node root = new Node(5);
        root.setLeftChild(new Node(7));
        root.setRightChild(new Node(8));
        root.getLeftChild().setLeftChild(new Node(2));
        root.getLeftChild().setRightChild(new Node(3));
        root.getRightChild().setLeftChild(root.getLeftChild().getRightChild());
        root.getRightChild().setRightChild(new Node(4));
        root.getLeftChild().getLeftChild().setLeftChild(new Node(4));
        root.getLeftChild().getLeftChild().setRightChild(new Node(9));
        root.getLeftChild().getRightChild().setLeftChild(root.getLeftChild().getLeftChild().getRightChild());
        root.getLeftChild().getRightChild().setRightChild(new Node(6));
        root.getRightChild().getRightChild().setLeftChild(root.getLeftChild().getRightChild().getRightChild());
        root.getRightChild().getRightChild().setRightChild(new Node(1));

        PascalTriangle pascalTriangle = new PascalTriangle();
        int shortestPath = pascalTriangle.findShortestPath(root,4);
        System.out.println("最短路径长度：" + shortestPath);

        //最短路径=:[5, 7, 2, 4]
        //最短路径=:[5, 8, 4, 1]
        //最短路径长度：18
    }
}
