package 链表;

import java.io.PipedReader;

/**
 * @author hanbing
 * @create 2020-04-07 13:47
 */

//https://leetcode-cn.com/problems/add-two-numbers-ii/
public class _445_两数相加2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = fanzhuan(l1);
        l2 = fanzhuan(l2);
        ListNode newsum = new ListNode(-1);
        ListNode tail = newsum;
        int sum = 0;
        int flag = 0;
        ListNode newnode = null;

        while (l1!=null || l2!=null){
            sum = 0;
            if (l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += flag;
            flag = sum/10;
            sum%=10;
            newnode = new ListNode(sum);

            tail.next = newnode;
            tail = newnode;
        }
        if (flag==1){
            tail.next = new ListNode(1);
        }
        return fanzhuan(newsum.next);
    }

    private ListNode fanzhuan(ListNode head){
        if (head==null || head.next==null) return head;

        ListNode newhead = fanzhuan(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
}
