package com.dpp.link;

/**
 * @author dpp
 * @date 2024/6/14
 * @Description 两个有序链表的合并
 */
public class LinkMerge {
    /**
     * 合并两个有序链表算法
     * @param linkNode1
     * @param linkNode2
     * @return
     */
    public static LinkNode merge(LinkNode linkNode1,LinkNode linkNode2){
        if (linkNode1 == null){
            return linkNode2;
        }
        if (linkNode2 == null) {
            return linkNode1;
        }
        LinkNode head = null;
        LinkNode current = null;
        while (true){
            if (linkNode1 == null){
                current.setNext(linkNode2);
                break;
            }
            if (linkNode2 == null){
                current.setNext(linkNode1);
                break;
            }
            if(linkNode1.getData() < linkNode2.getData()){
                if(head == null){
                    head = linkNode1;
                    current = head;
                }else {
                    current.setNext(linkNode1);
                    current = linkNode1;
                }
                linkNode1 = linkNode1.getNext();
            }else {
                if(head == null){
                    head = linkNode2;
                    current = head;
                }else {
                    current.setNext(linkNode2);
                    current = linkNode2;
                }
                linkNode2 = linkNode2.getNext();
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LinkNode linkNode1 = new LinkNode(1);
        LinkNode linkNode2 = new LinkNode(2);
        LinkNode linkNode3 = new LinkNode(3);
        LinkNode linkNode4 = new LinkNode(10);
        linkNode1.setNext(linkNode2);
        linkNode2.setNext(linkNode3);
        linkNode3.setNext(linkNode4);

        LinkNode node1 = new LinkNode(3);
        LinkNode node2 = new LinkNode(4);
        LinkNode node3 = new LinkNode(5);
        LinkNode node4 = new LinkNode(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        System.out.println(linkNode1);
        System.out.println(node1);
        System.out.println(merge(linkNode1, node1));
    }
}
