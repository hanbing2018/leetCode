package 链表;

//https://leetcode-cn.com/problems/reorder-list/
public class todo_143_重排链表 {

    /**
     * 1.找到中间节点
     * 2.将后半段链表翻转(或者将后半段节点依次放入栈中)
     * 3.将翻转的链表节点依次插入到前半段
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        //找到中间节点，偶数的话找到前一个节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //翻转后半段链表
        ListNode rHead = reverse(slow.next);
        ListNode tr = rHead;

        //将前半段尾结点的next为空
        slow.next = null;

        ListNode lHead = head;
        ListNode tl = lHead;
        while (lHead != null && rHead != null) {
            tr = rHead.next;
            tl = lHead.next;
            rHead.next = lHead.next;
            lHead.next = rHead;

            rHead = tr;
            lHead = tl;
        }
    }

    /**
     * 翻转链表
     *
     * @param root
     * @return
     */
    private ListNode reverse(ListNode root) {
        if (root == null) return null;

        ListNode t = root;
        ListNode newHead = null;
        while (root != null) {
            t = root.next;
            root.next = newHead;
            newHead = root;
            root = t;
        }

        return newHead;
    }
}
