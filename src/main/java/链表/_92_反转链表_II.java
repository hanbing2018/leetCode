package 链表;

public class _92_反转链表_II {

    //https://leetcode-cn.com/problems/reverse-linked-list-ii/

    /**
     * 两层递归。首先构造递归函数能够翻转前k个节点，再递归调用此函数即可
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseK(head, n);
        }
        ListNode newHead = reverseBetween(head.next, m - 1, n - 1);
        head.next = newHead;
        return head;
    }


    //翻转链表前k个节点，这个函数可以当做通用函数用在链表翻转类的题目中
    //用一个全局变量next指向第k+1个节点
    ListNode next = null;

    private ListNode reverseK(ListNode head, int k) {
        if (k == 1) {
            next = head.next;
            return head;
        }
        ListNode newHead = reverseK(head.next, k - 1);
        head.next.next = head;
        head.next = next;

        return newHead;
    }
}
