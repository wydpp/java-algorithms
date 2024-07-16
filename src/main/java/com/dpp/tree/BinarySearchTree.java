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

    /**
     * 插入叶子节点的左边或右边
     *
     * @param data
     * @return
     */
    public Node insert(int data) {
        Node n = null;
        if (root == null) {
            root = new Node(data);
            n = root;
        } else {
            Node node = root;
            while (true) {
                if (node.getData() < data) {
                    Node rightNode = node.getRightChild();
                    if (rightNode == null) {
                        n = new Node(data);
                        node.setRightChild(n);
                        break;
                    }
                    node = rightNode;
                } else {
                    Node leftNode = node.getLeftChild();
                    if (leftNode == null) {
                        n = new Node(data);
                        node.setLeftChild(n);
                        break;
                    }
                    node = leftNode;
                }
            }
        }
        return n;
    }

    /**
     * 二叉查找树的删除操作
     * 1. 如果要删除的节点没有子节点，我们只需要直接将父节点中，指向要删除节点的指针置为null。
     * 2. 如果要删除的节点只有一个子节点（只有左子节点或者右子节点），我们只需要更新父节中，指向要删除节点的指针，让它指向要删除的节点的子节点就可以了。
     * 3. 如果要删除的节点有两个子节点，我们需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。然后再删除掉这个最小节点，
     * 因为最小节点肯定没有左子节点（如果有左子节点，就不是最小节点），所以，我们可以应用上面两条规则来删除这个最小节点。
     *
     * @param n
     * @return
     */
    public Node delete(int n) {
        Node p = root;
        Node parentNode = null;
        //找到要删除的节点和它的父节点
        while (p != null) {
            if (p.getData() == n) {
                break;
            } else if (p.getData() < n) {
                parentNode = p;
                p = p.getRightChild();
            } else {
                parentNode = p;
                p = p.getLeftChild();
            }
        }
        if (p != null) {
            if (p.getLeftChild() == null && p.getRightChild() == null) {
                //要删除的节点p，没有子节点
                if (parentNode != null) {
                    if (parentNode.getLeftChild() == p) {
                        parentNode.setLeftChild(null);
                    } else {
                        parentNode.setRightChild(null);
                    }
                }
            } else if (p.getLeftChild() == null || p.getRightChild() == null) {
                //有一个子节点
                if (parentNode == null) {
                    //删除的是根节点
                    if (p.getLeftChild() != null) {
                        root = p.getLeftChild();
                    } else {
                        root = p.getRightChild();
                    }
                } else {
                    Node child = null;
                    if (p.getLeftChild() != null) {
                        child = p.getLeftChild();
                    } else {
                        child = p.getRightChild();
                    }
                    if (parentNode.getLeftChild() == p) {
                        parentNode.setLeftChild(child);
                    } else {
                        parentNode.setRightChild(child);
                    }
                }
            } else {
                //有两个子节点
                Node rightNode = p.getRightChild();
                //找到最小节点和其父节点
                Node minNode = rightNode;
                Node minParentNode = p;
                Node leftNode = minNode.getLeftChild();
                while (leftNode != null) {
                    minParentNode = minNode;
                    minNode = leftNode;
                }
                minNode.setLeftChild(p.getLeftChild());
                minNode.setRightChild(p.getRightChild());
                minParentNode.setLeftChild(null);
                if (parentNode.getLeftChild() == p) {
                    parentNode.setLeftChild(minNode);
                } else {
                    parentNode.setRightChild(minNode);
                }
            }
            p.setLeftChild(null);
            p.setRightChild(null);
        }
        return p;
    }

    public static void main(String[] args) {
        Node root = new Node(33);
        Node left = new Node(16);
        root.setLeftChild(left);
        left.setLeftChild(new Node(13));
        Node right = new Node(18);
        left.setRightChild(right);
        right.setLeftChild(new Node(17));
        right.setRightChild(new Node(25));
    }

}
