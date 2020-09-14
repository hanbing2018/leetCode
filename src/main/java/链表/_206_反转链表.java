package 链表;

/**
 * @author hanbing
 * @create 2019-12-03 14:39
 */

//https://leetcode-cn.com/problems/reverse-linked-list/
public class _206_反转链表 {

    /**
     * 有三个常见算法。
     * 方法一：递归
     * @param head
     * @return
     */
    ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 方法二：迭代
     * @param head
     * @return
     */
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

    //方法三：用一个栈依次加入节点，依次取出即可
}
