package 链表;

import java.awt.*;

/**
 * @author hanbing
 * @create 2019-12-03 15:09
 */

//https://leetcode-cn.com/problems/remove-linked-list-elements/
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val){
            head = head.next;
        }

        if (head == null || head.next == null){
            return head;
        }
        ListNode tmp = head;

        while (tmp.next != null){
            if (tmp.next.val == val){
                tmp.next = tmp.next.next;
            }else {
                tmp = tmp.next;
            }
        }

        return head;
    }
}
