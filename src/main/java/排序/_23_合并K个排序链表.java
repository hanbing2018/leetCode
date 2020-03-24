package 排序;

/**
 * @author hanbing
 * @create 2020-02-15 22:24
 */

//https://leetcode-cn.com/problems/merge-k-sorted-lists/
public class _23_合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) return null;
        ListNode l = lists[0];
        for (int i = 1; i < length; i++) {
            l = mergeTwoLists(l, lists[i]);
        }
        return l;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode l = new ListNode(0);
        ListNode head = l;
        while (head1 != null && head2 != null){
            if (head1.val < head2.val){
                head.next = new ListNode(head1.val);
                head1 = head1.next;
                head = head.next;
            }else {
                head.next = new ListNode(head2.val);
                head2 = head2.next;
                head = head.next;
            }
        }
        while (head1 != null){
            head.next = new ListNode(head1.val);
            head1 = head1.next;
            head = head.next;
        }
        while (head2 != null){
            head.next = new ListNode(head2.val);
            head2 = head2.next;
            head = head.next;
        }

        l = l.next;
        return l;
    }
}
