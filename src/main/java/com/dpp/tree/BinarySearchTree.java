package com.dpp.tree;

/**
 * @author dpp
 * @date 2024/7/12
 * @Description 二叉查找树
 */
public class BinarySearchTree {

    private Node root;

    public Node find(int data) {
        Node p = root;
        while (p != null) {
            if (p.getData() == data) {
                return p;
            } else if (p.getData() < data) {
                p = p.getRightChild();
            } else {
                p = p.getLeftChild();
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
