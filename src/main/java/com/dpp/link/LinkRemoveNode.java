package com.dpp.link;

/**
 * @author dpp
 * @date 2024/6/14
 * @Description 删除链表倒数第n个节点
 */
public class LinkRemoveNode {

    /**
     * 快慢指针算法：
     * 块指针先走n步，然后快慢指针一起走，当快指针下一个为null时，慢指针对应的下一个node是要删除的node。
     *
     * @param linkNode
     * @param n
     */
    public static LinkNode removeNode(LinkNode linkNode, int n) {
        if (linkNode == null) {
            return null;
        }
        if (linkNode.getNext() == null) {
            return null;
        }
        LinkNode fast = linkNode;
        LinkNode slow = linkNode;
        for (int i = 0; i < n; i++) {
            fast = fast.getNext();
        }
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        LinkNode pre = slow;
        LinkNode next = slow.getNext().getNext();
        pre.setNext(next);
        return linkNode;
    }

    public static void main(String[] args) {
        LinkNode linkNode = new LinkNode(1);
        linkNode.setNext(new LinkNode(2));
        linkNode.getNext().setNext(new LinkNode(3));
        linkNode.getNext().getNext().setNext(new LinkNode(4));
        linkNode.getNext().getNext().getNext().setNext(new LinkNode(5));
        System.out.println(linkNode);
        LinkNode removeNode = removeNode(linkNode, 2);
        System.out.println(removeNode);
    }
}
