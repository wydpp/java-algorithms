package com.dpp.link;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dpp
 * @date 2024/6/14
 * @Description 链表环形检测
 */
public class CycleLink {
    /**
     * 检测链表中是否有环形。
     * 快慢指针算法，龟兔赛跑算法：快指针每次走两步，慢指针每次走一步，没有还的情况下，两者不会相遇。如果有环结构，再环里面，每走一步，快指针和慢指针之间的距离-1，
     * 所以总有一个时刻，他们会相遇。如果相遇，证明链表有环。
     *
     * @param linkNode
     * @return
     */
    public static boolean hasCycle(LinkNode linkNode) {
        if (linkNode == null || linkNode.getNext() == null) {
            return false;
        }
        LinkNode slow = linkNode;
        LinkNode fast = linkNode.getNext();
        while (slow != fast) {
            if (slow == null || fast == null || fast.getNext() == null) {
                return false;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return true;
    }

    /**
     * 使用多余空间存储每个节点数据，如果节点数据重复了，表明有环
     * @param linkNode
     * @return
     */
    public static boolean hasCycle2(LinkNode linkNode) {
        Set<LinkNode> nodeSet = new HashSet<>();
        while (linkNode != null) {
            //add方法：如果添加对象set中没有，会返回true
            if (!nodeSet.add(linkNode)) {
                return true;
            }
            linkNode = linkNode.getNext();
        }
        return false;
    }

    public static void main(String[] args) {
        LinkNode linkNode = new LinkNode(1);
        LinkNode linkNode2 = new LinkNode(2);
        LinkNode linkNode3 = new LinkNode(3);
        LinkNode linkNode4 = new LinkNode(4);
        linkNode.setNext(linkNode2);
        linkNode2.setNext(linkNode3);
        linkNode3.setNext(linkNode4);
        System.out.println(hasCycle(linkNode));
        linkNode4.setNext(linkNode);
        System.out.println(hasCycle(linkNode));
        System.out.println(hasCycle2(linkNode));
    }
}
