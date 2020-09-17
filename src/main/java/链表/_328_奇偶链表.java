package 链表;

//https://leetcode-cn.com/problems/odd-even-linked-list/
public class _328_奇偶链表 {

    /**
     * 首先要保留偶数节点链表的头节点。
     * 用奇偶两个指针依次向后移动取出奇数节点和偶数节点。
     * 最后将偶数节点链表尾节点的next置空，将偶数节点链表接在技术节点链表尾部。
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode ji = head;
        ListNode ou = ji.next;
        ListNode ouHead = ou;
        while (ji.next!=null && ou.next!=null){
            if (ji.next == ou){
                ji.next = ou.next;
                ji = ji.next;
                continue;
            }
            if (ou.next == ji){
                ou.next = ji.next;
                ou = ou.next;
            }
        }
        ou.next = null;
        ji.next = ouHead;
        return head;
    }
}
