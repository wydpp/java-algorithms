package com.dpp.tree;

/**
 * @author dpp
 * @date 2024/7/12
 * @Description
 */
public class Node {
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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
