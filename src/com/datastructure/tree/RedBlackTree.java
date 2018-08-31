package com.datastructure.tree;

import java.util.Objects;

/**
 * @author zhengguobin1@jd.com
 * @date 2018/8/30 16:05
 */
public class RedBlackTree<T extends Comparable> {
    //定义红黑树的颜色
    private static final Boolean RED = false;
    private static final Boolean BLACK = true;

    static class Node {
        Object data;
        Node parent;
        Node left;
        Node right;
        //节点的默认颜色是黑色
        boolean color = BLACK;

        public Node(Object data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", color=" + color +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data);
        }
    }

    private Node root;

    public RedBlackTree() {
        this.root = null;
    }

    public RedBlackTree(Node o) {
        this.root = new Node(0, null, null, null);
    }

    //添加节点
    public void add(T ele) {
        //如果根节点为null
        if (root == null) {
            root = new Node(ele, null, null, null);
        } else {
            Node current = root;
            Node parent = null;
            int cmp = 0;
            //搜索合适的叶子节点，以该叶子节点为父节点添加新节点
            do {
                parent = current;
                cmp = ele.compareTo(current.data);
                if (cmp > 0) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            } while (current != null);
            Node newNode = new Node(ele, parent, null, null);
            //如果新节点的值大于父节点的值
            if (cmp > 0) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
            //维护红黑树
            fixAfterInsertion(newNode);
        }
    }

    //获取指点节点的父节点
    private Node parentOf(Node p) {
        return (p == null ? null : p.parent);
    }

    //获取指点节点的左子节点
    private Node leftOf(Node p) {
        return (p == null) ? null : p.left;
    }

    private Node rightOf(Node p) {
        return (p == null ? null : p.right);
    }

    private boolean colorOf(Node p) {
        return (p == null ? null : p.color);
    }

    private void setColor(Node p, boolean c) {
        if (null != p) {
            p.color = c;
        }
    }

    public void fixAfterInsertion(Node x) {
        x.color = RED;
        //直到x节点的父节点不是根，且x的父节点不是红色
        while (x != null && x != root && x.parent.color == RED) {
            //如果x的父节点是其父节点的左子节点
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                //获取x的父节点的兄弟节点
                Node y = rightOf(parentOf(parentOf(x)));
                //如果x的父节点的兄弟节点是红色
                if (colorOf(y) == RED) {
                    //将x的父节点设为黑色
                    setColor(parentOf(x), BLACK);
                    //将x的父节点的兄弟接地设为黑色
                    setColor(y, BLACK);
                    //将x的父节点的父节点设为红色
                    setColor(parentOf(parentOf(x)), RED);
                    //将x设为x的父节点的节点
                    x = parentOf(parentOf(x));
                }
                //如果x的父节点的兄弟节点是黑色
                else {
                    //如果x是其父节点的右子节点
                    if (x == rightOf(parentOf(x))) {
                        //将x的父节点设为x
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    //把x的父节点设为黑色
                    setColor(parentOf(x), BLACK);
                    //把x的父节点的父节点设为红色
                    setColor(parentOf(parentOf(x)), RED);
                    rotateRight(parentOf(parentOf(x)));
                }
            }
            //如果x的父节点是其父节点的右子节点
            else {
                //获取x的父节点的兄弟节点
                Node y = leftOf(parentOf(parentOf(x)));
                //如果x的父节点的兄弟节点是红色
                if (colorOf(y) == RED) {
                    //将x的父节点设为黑色
                    setColor(parentOf(x), BLACK);
                    //将x的父节点的兄弟节点设为黑色
                    setColor(y, BLACK);
                    //将x的父节点的父节点设为红色
                    setColor(parentOf(parentOf(x)), RED);
                    //将x设为x的父节点的节点
                    x = parentOf(parentOf(x));
                }
                //如果x的父节点的兄弟节点是黑色
                else {
                    //如果x是其父节点的左子节点
                    if (x == leftOf(parentOf(x))) {
                        //将x的父节点设为x
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    //把x的父节点设为黑色
                    setColor(parentOf(x), BLACK);
                    //把x的父节点的父节点设为红色
                    setColor(parentOf(parentOf(x)), RED);
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        //将根节点设置为黑色
        root.color = BLACK;
    }

    //左旋
    private void rotateLeft(Node p) {
        if (p != null) {
            //取得p的右子节点
            Node r = p.right;
            Node q = r.left;
            //将r的左子节点链到p的右节点链上
            p.right = q;
            if (q != null) {
                q.parent = p;
            }
            r.parent = p.parent;
            if (p.parent == null) {
                root = r;
            } else if (p.parent.left == p) {
                p.parent.left = r;
            } else {
                p.parent.right = r;
            }
            r.left = p;
            p.parent = r;
        }
    }

    //右旋
    private void rotateRight(Node p) {
        if (p != null) {
            Node l = p.left;
            Node q = l.right;
            p.left = q;
            if (q != null) {
                q.parent = p;
            }
            l.parent = p.parent;
            if (p.parent == null) {
                root = l;
            } else if (p.parent.right == p) {
                p.parent.right = l;
            } else {
                p.parent.left = l;
            }
            l.right = p;
            p.parent = l;
        }
    }
}
