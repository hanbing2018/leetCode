package 链表;

/**
 * @author hanbing
 * @create 2019-12-03 14:58
 */

//https://leetcode-cn.com/problems/linked-list-cycle/
public class _141_环形链表 {
    /**
     * 快慢指针，两针相遇即为有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
