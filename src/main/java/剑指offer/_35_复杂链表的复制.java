package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanbing
 * @create 2020-04-17 16:26
 */

//https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
public class _35_复杂链表的复制 {

    /**
     * 方法一：利用map存储原节点与新节点的对应关系，推荐
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 虚拟头结点
        Node newhead = new Node(-1);
        Node oldLast = head;
        Node newLast = newhead;
        Map<Node, Node> map = new HashMap<>();
        while (oldLast != null) {
            Node tem = new Node(oldLast.val);
            newLast.next = tem;
            newLast = tem;
            map.put(oldLast, tem);
            oldLast = oldLast.next;
        }

        newhead = newhead.next;

        oldLast = head;
        newLast = newhead;
        while (newLast != null) {
            newLast.random = map.get(oldLast.random);
            newLast = newLast.next;
            oldLast = oldLast.next;
        }
        return newhead;
    }

    //方法二：在原链表中复制新节点，此方法时间过长！！！
    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        Node last = head;
        while (last != null) {
            Node tem = new Node(last.val);
            tem.next = last.next;
            last.next = tem;
            last = last.next.next;
        }
        last = head;
        while (last != null) {
            if (last.random != null) {
                last.next = last.random.next;
            }
            last = last.next.next;
        }
        Node newhead = head.next;

        Node newlast = newhead;
        last = head;
        while (last != null) {
            last.next = newlast.next;
            last = last.next;
            newlast.next = last.next;
            newlast = newlast.next;
        }
        return newhead;
    }

    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
