package 排序;

import java.util.List;

/**
 * @author hanbing
 * @create 2020-02-15 21:55
 */

//https://leetcode-cn.com/problems/merge-two-sorted-lists/comments/
public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
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
}
