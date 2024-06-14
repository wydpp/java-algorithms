package com.dpp.link;

/**
 * @author dpp
 * @date 2024/6/14
 * @Description
 */
public class LinkNode {

    private int data;

    private LinkNode next;

    private LinkNode pre;

    public LinkNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public LinkNode getPre() {
        return pre;
    }

    public void setPre(LinkNode pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LinkNode{");
        sb.append("data=").append(data);
        sb.append(", next=").append(next);
        sb.append(", pre=").append(pre);
        sb.append('}');
        return sb.toString();
    }
}
