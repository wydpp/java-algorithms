package com.dpp.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dpp
 * @date 2024/7/12
 * @Description
 */
public class LinkTree {
    /**
     * 树结构-链式存储
     */
    private static class Node {
        //值
        private int data;
        //左子节点
        private Node leftChild;
        //右子节点
        private Node rightChild;
        //父节点
        private Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 前序遍历所有节点：先打印这个节点，然后再打印它的左子树，最后打印它的右子树。
     * 递推公式： preOrder(r) = print(r) + preOrder(r->left) + preOrder(r->right)
     *
     * @return
     */
    public static List<Integer> preOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        doPreOrder(root, result);
        return result;
    }

    private static void doPreOrder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.data);
        doPreOrder(node.leftChild, result);
        doPreOrder(node.rightChild, result);
    }

    /**
     * 按层遍历：按层从第一层开始遍历
     * 递推公式： levelOrder(r) =
     * @param root
     * @return
     */
    private static List<Integer> levelOrder(Node root){
        //TODO
        return null;
    }

    /**
     * 中序遍历：先打印它的左子树，然后再打印它本身，最后打印它的右子树。
     * 递推公式：inOrder(r) = inOrder(r->left) -> print(r) -> inOrder(r->right)
     *
     * @param root
     * @return
     */
    public static List<Integer> inOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        doInOrder(root, result);
        return result;
    }

    private static void doInOrder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        doInOrder(node.leftChild, result);
        result.add(node.data);
        doInOrder(node.rightChild, result);
    }

    /**
     * 后序遍历：先打印它的左子树，再打印它的右子树，再打印本身
     * 递推公式：posterOrder(r) = posterOrder(r->left) -> posterOrder(r->right) -> print(r)
     *
     * @param root
     * @return
     */
    public static List<Integer> posterOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        doPosterOrder(root, result);
        return result;
    }

    private static void doPosterOrder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        doPosterOrder(node.leftChild, result);
        doPosterOrder(node.rightChild, result);
        result.add(node.data);
    }


    public static void main(String[] args) {
        Node root = new Node(1);

        Node node2 = new Node(2);
        root.leftChild = node2;
        node2.parent = root;

        Node node3 = new Node(3);
        node2.leftChild = node3;
        node3.parent = node2;

        Node node4 = new Node(4);
        node2.rightChild = node4;
        node4.parent = node2;

        Node node5 = new Node(5);
        root.rightChild = node5;
        node5.parent = root;

        Node node6 = new Node(6);
        node5.leftChild = node6;
        node6.parent = node5;

        Node node7 = new Node(7);
        node5.rightChild = node7;
        node7.parent = node5;

        List<Integer> values = preOrder(root);
        System.out.println(values);

        values = inOrder(root);
        System.out.println(values);

        values = posterOrder(root);
        System.out.println(values);
    }

}
