package 链表;

/**
 * @author hanbing
 * @create 2019-12-03 15:25
 */

//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
public class _83_删除排序链表中的重复元素 {

    /**
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            if (tmp.val == tmp.next.val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }

        return head;
    }
}
