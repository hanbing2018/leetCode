package 链表;

//https://leetcode-cn.com/problems/swap-nodes-in-pairs/
public class _24_两两交换链表中的节点 {

    /**
     * 利用递归翻转以head.next.next为头节点的链表。交换前连个节点的位置并连接剩下的链表
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode t = head.next;
        head.next = swapPairs(head.next.next);
        t.next = head;
        return t;
    }
}
