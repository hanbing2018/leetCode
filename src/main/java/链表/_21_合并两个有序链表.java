package 链表;

/**
 * @author hanbing
 * @create 2020-02-15 21:55
 */

//https://leetcode-cn.com/problems/merge-two-sorted-lists/comments/
public class _21_合并两个有序链表 {
    /**
     * 方法一：依次遍历两个链表生成新的节点
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        // 虚拟头结点
        ListNode l = new ListNode(0);
        ListNode head = l;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head.next = new ListNode(head1.val);
                head1 = head1.next;
                head = head.next;
            } else {
                head.next = new ListNode(head2.val);
                head2 = head2.next;
                head = head.next;
            }
        }
        while (head1 != null) {
            head.next = new ListNode(head1.val);
            head1 = head1.next;
            head = head.next;
        }
        while (head2 != null) {
            head.next = new ListNode(head2.val);
            head2 = head2.next;
            head = head.next;
        }

        l = l.next;
        return l;
    }


    /**
     * 方法二：递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 递归基
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
