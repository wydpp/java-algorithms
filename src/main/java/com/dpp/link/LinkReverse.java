package com.dpp.link;

/**
 * @author dpp
 * @date 2024/6/14
 * @Description 链表反转
 */
public class LinkReverse {
    /**
     * 反转链表
     * @param linkNode 一个链表
     */
    public static LinkNode reverse(LinkNode linkNode){
        if (linkNode == null || linkNode.getNext() == null){
            return linkNode;
        }
        LinkNode pre = null;
        LinkNode current = linkNode;
        while (current != null){
            LinkNode next = current.getNext();
            current.setNext(pre);
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        LinkNode linkNode = new LinkNode(1);
        LinkNode linkNode2 = new LinkNode(2);
        LinkNode linkNode3 = new LinkNode(3);
        linkNode.setNext(linkNode2);
        linkNode2.setNext(linkNode3);
        System.out.println(linkNode);
        linkNode = reverse(linkNode);
        System.out.println(linkNode);
    }

}
