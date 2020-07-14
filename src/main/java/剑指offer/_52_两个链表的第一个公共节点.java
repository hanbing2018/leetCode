package 剑指offer;



//https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
public class _52_两个链表的第一个公共节点 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;

        ListNode curA = headA;
        ListNode curB = headB;

        while (curA!=curB){
            curA = curA==null ? headB : curA.next;
            curB = curB==null ? headA : curB.next;
        }

        return curA;
    }



}
