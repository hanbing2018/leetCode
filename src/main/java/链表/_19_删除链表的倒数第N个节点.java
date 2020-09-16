package 链表;

//https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
public class _19_删除链表的倒数第N个节点 {
    /**
     * 双指针问题，两个指针相差N，当前一个指针指向最后一个节点时，后一个指针指向需要删除的节点的前一个节点。
     * 一次遍历即可。在头节点前边增加一个辅助节点是常用技巧
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null) return head;

        ListNode low = new ListNode(-1);
        low.next = head;
        ListNode fast = low;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (head.next!=null){
            fast = fast.next;
            low = low.next;
        }
        //如果要删除的节点是头节点
        if (low.next == head){
            return head.next;
        }
        low.next = low.next.next;
        return head;
    }
}
