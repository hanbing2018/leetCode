package 二叉树;


import java.util.LinkedList;
import java.util.Queue;

//https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
public class _117_填充每个节点的下一个右侧节点指针_II {

    /**
     * 方法一：用队列层序遍历
     * 时间复杂度O(n),空间复杂度O(n)
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        int curNum = 1;
        int nextNum = 0;
        queue.offer(root);
        Node pre = null;
        while (!queue.isEmpty()) {
            Node t = queue.poll();
            curNum--;

            //遍历的是当前行的第一个节点
            if (pre == null) {
                pre = t;
            } else {
                pre.next = t;
                pre = pre.next;
            }

            if (t.left != null) {
                queue.offer(t.left);
                nextNum++;
            }
            if (t.right != null) {
                queue.offer(t.right);
                nextNum++;
            }

            //如果遍历的节点是当前行的最后一个节点
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                pre = null;
            }
        }
        return root;
    }

    /**
     * 方法二：还是用层序遍历。利用next将空间复杂度变为O(1)。综合性能比方法一好
     *
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) return null;
        //当前层遍历的头节点
        Node start = root;
        while (start != null) {
            Node p = start;
            //下一层的头节点
            Node nextStart = null;
            //下一层链表的前一个节点
            Node pre = null;
            while (p != null) {
                if (p.left != null) {
                    if (nextStart == null) {
                        nextStart = p.next;
                    }
                    if (pre == null) {
                        pre = p.left;
                    } else {
                        pre.next = p.left;
                        pre = pre.next;
                    }
                }
                if (p.right != null) {
                    if (nextStart == null) {
                        nextStart = p.next;
                    }
                    if (pre == null) {
                        pre = p.right;
                    } else {
                        pre.next = p.right;
                        pre = pre.next;
                    }
                }
                p = p.next;
            }
            start = nextStart;
        }

        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
