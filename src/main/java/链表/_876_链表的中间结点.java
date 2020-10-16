package 链表;

/**
 * @author hanbing
 * @create 2019-12-03 15:34
 */

//https://leetcode-cn.com/problems/middle-of-the-linked-list/
public class _876_链表的中间结点 {

    /**
     * 快慢指针，快指针一次走两步，慢指针一次走一步
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
