package 恋上数据结构第三季;

/**
 * @author hanbing
 * @date 2020-08-13 22:33
 */

//https://leetcode-cn.com/problems/partition-list/
public class _86_分隔链表 {

    /**
     * 先将链表节点依次分隔到左右两个链表，再将两个链表连接
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode lHead = new ListNode(-1);
        ListNode lTail = lHead;

        ListNode rHead = new ListNode(-1);
        ListNode rTail = rHead;
        while (head != null) {
            if (head.val < x) {
                lTail.next = head;
                lTail = head;
            } else {
                rTail.next = head;
                rTail = head;
            }
            head = head.next;
        }

        rTail.next = null;
        lTail.next = rHead.next;

        return lHead.next;
    }
}
