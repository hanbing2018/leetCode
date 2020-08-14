package 恋上数据结构第三季;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hanbing
 * @date 2020-08-13 22:37
 */

//https://leetcode-cn.com/problems/palindrome-linked-list/
public class _234_回文链表 {


    /**
     * 方法一：时间复杂度O(n),空间复杂度O(n)
     * 用一个栈和一个队列，依次比较即可
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> queue = new LinkedList<>();
        while (head != null){
            stack.push(head);
            queue.offer(head);
            head = head.next;
        }
        int len = stack.size()/2;
        for (int i = 0; i < len; i++) {
            if (stack.pop().val!=queue.poll().val) return false;
        }
        return true;
    }


    /**
     * 方法二：翻转链表后半段，依次和前半段节点值比较，时间复杂度O(n),空间复杂度O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;

        // 找到中间节点
        ListNode mid = middleNode(head);
        // 翻转右半部分（中间节点的右边部分）
        ListNode rHead = reverseList(mid.next);
        ListNode lHead = head;
        ListNode rOldHead = rHead;

        // 从lHead、rHead出发，判断是否为回文链表
        boolean result = true;
        while (rHead != null) {
            if (lHead.val != rHead.val) {
                result = false;
                break;
            }
            rHead = rHead.next;
            lHead = lHead.next;
        }

        // 恢复右半部分（对右半部分再次翻转）
        reverseList(rOldHead);
        return result;
    }

    /**
     * 找到中间节点（右半部分链表头结点的前一个节点）
     * 比如 1>2>3>2>1中的3是中间节点
     * 比如 1>2>2>1中左边第一个2是中间节点
     * @param head
     * @return
     */
    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 翻转链表
     * @param head 原链表的头结点
     * 比如原链表：1>2>3>4>null，翻转之后是：4>3>2>1>null
     * @return 翻转之后链表的头结点（返回4）
     */
    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}
