package 链表;

public class _92_反转链表_II {

    //https://leetcode-cn.com/problems/reverse-linked-list-ii/

    /**
     * 两层递归。首先构造递归函数能够翻转前k个节点，再递归调用此函数即可
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1){
            return reverseN(head, n);
        }
        ListNode newHead = reverseBetween(head.next, m-1, n-1);
        head.next = newHead;
        return head;
    }


    //翻转链表前k个节点
    ListNode next = null;
    private ListNode reverseN(ListNode head, int k){
        if (k == 1){
            next = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, k-1);
        head.next.next = head;
        head.next = next;

        return newHead;
    }
}
