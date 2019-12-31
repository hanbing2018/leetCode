package 链表;

/**
 * @author hanbing
 * @create 2019-12-03 14:39
 */

//https://leetcode-cn.com/problems/reverse-linked-list/
public class _206_反转链表 {

    //递归方式
    ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    //非递归方式
    ListNode reverseList2(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
