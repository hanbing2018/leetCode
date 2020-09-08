package 链表;


//https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
public class _25_K个一组翻转链表 {


    /**
     * 方法一：利用92题，利用翻转m到n的节点的算法，依次翻转每一组
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1) return head;
        ListNode temHead = head;
        int count = 1;
        int start = 1;
        while (temHead!=null){
            if (count==k){  //此时temHead指向一组的尾结点
                temHead = temHead.next;
                count = 1;
                head = reverseMN(head, start, start+k-1);
                start+=k;
            }else {
                temHead = temHead.next;
                count++;
            }

        }

        return head;
    }

    //翻转链表m到n的节点(m从1开始)
    private ListNode reverseMN(ListNode head, int m, int n){
        if (m==1){
            return reverseN(head, n);
        }
        ListNode newHead = reverseMN(head.next, m-1, n-1);
        head.next = newHead;
        return head;
    }

    //翻转链表的前k个节点
    ListNode next = null;
    private ListNode reverseN(ListNode head, int k){
        if (k==1){
            next = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, k-1);
        head.next.next = head;
        head.next = next;
        return newHead;
    }
}
