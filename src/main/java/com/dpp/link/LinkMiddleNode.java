package com.dpp.link;

/**
 * @author dpp
 * @date 2024/6/14
 * @Description 获取一个链表的中间节点
 */
public class LinkMiddleNode {
    /**
     * 快慢指针算法：慢指针每次走一步，快指针买次走两步，当快指针是null或next是null则slow就是中间节点。
     * @param linkNode
     * @return
     */
    public static LinkNode getMiddleNode(LinkNode linkNode){
        if (linkNode == null){
            return null;
        }
        LinkNode slow = linkNode;
        LinkNode fast = linkNode;
        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkNode linkNode = new LinkNode(1);
        linkNode.setNext(new LinkNode(2));
        linkNode.getNext().setNext(new LinkNode(3));
        linkNode.getNext().getNext().setNext(new LinkNode(4));
        linkNode.getNext().getNext().getNext().setNext(new LinkNode(5));
        System.out.println(linkNode);
        System.out.println(getMiddleNode(linkNode));
    }
}
