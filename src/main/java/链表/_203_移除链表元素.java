package 链表;

/**
 * @author hanbing
 * @create 2019-12-03 15:09
 */

//https://leetcode-cn.com/problems/remove-linked-list-elements/
public class _203_移除链表元素 {

    /**
     * 移除链表的中值为给定值的节点，这样的节点可能有多个
     * 1、头节点移动先排除链表头部的节点
     * 2、遍历，如果发现下一个节点应该删除，就将当前节点的next指向下一个节点的next
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head;

        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }

        return head;
    }
}
