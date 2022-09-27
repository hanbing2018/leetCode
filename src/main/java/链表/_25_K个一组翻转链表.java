package 链表;


//https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
public class _25_K个一组翻转链表 {


    /**
     * 本题难度hard，推荐方法二。方法一效率太低
     * 方法一：利用92题，利用翻转m到n的节点的算法，依次翻转每一组。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode temHead = head;
        int count = 1;
        int start = 1;
        while (temHead != null) {
            if (count == k) {  //此时temHead指向一组的尾结点
                temHead = temHead.next;
                count = 1;
                head = reverseMN(head, start, start + k - 1);
                start += k;
            } else {
                temHead = temHead.next;
                count++;
            }

        }

        return head;
    }

    //翻转链表m到n的节点(m从1开始)
    private ListNode reverseMN(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseK(head, n);
        }
        ListNode newHead = reverseMN(head.next, m - 1, n - 1);
        head.next = newHead;
        return head;
    }

    //翻转链表的前k个节点
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


    /**
     * 方法二：同样也是利用递归，利用反转[a, b)链表的函数进行递归翻转
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(head, b);
        head.next = reverseKGroup2(b, k); // 此时head变为前K个节点翻转后的尾结点
        return newHead;

    }

    //翻转链表从头节点到end节点（不包括end节点）
    private ListNode reverse(ListNode head, ListNode end) {
        ListNode saveHead = head;   //head始终指向同一个节点
        ListNode newHead = null;
        ListNode tem = null;
        while (saveHead != end) {
            tem = saveHead.next;
            saveHead.next = newHead;
            newHead = saveHead;
            saveHead = tem;
        }
        head.next = end;
        return newHead;
    }
}
