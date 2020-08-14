package 恋上数据结构第三季;

/**
 * @author hanbing
 * @date 2020-08-13 21:42
 */

//https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
public class _160_相交链表 {


    //两种方法

    /**
     * 方法一：将两个链表分别接到另一个链表的尾部进行判断是否相等
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA : curB.next;
            // 这段代码在两个链表不相交的时候会死循环
            // curA = (curA.next == null) ? headB : curA.next;
            // curB = (curB.next == null) ? headA : curB.next;
        }
        return curA;
    }


    /**
     * 方法二：将一个链表遍历，节点放入集合。遍历另一个链表，判断集合是否包含遍历的节点
     */
}
