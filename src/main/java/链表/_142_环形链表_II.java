package 链表;


//https://leetcode-cn.com/problems/linked-list-cycle-ii/
public class _142_环形链表_II {

    /**
     * 详细解法见 剑指offer 23题
     * 首先判断是否有环
     * 有环则得出环的数量num
     * fast=slow=head，fast移动num步；fast与slow同时移动，在环的入口相遇
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        //判断链表是否有环
        boolean flag = false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            //没有环
            return null;
        } else {
            //先得出环的节点的数量
            int num = 0;
            ListNode fast_temp = fast;
            while (true) {
                num++;
                fast = fast.next;
                if (fast == fast_temp) break;
            }

            fast = head;
            slow = head;
            while (num > 0) {
                fast = fast.next;
                num--;
            }
            while (true) {
                if (fast == slow) break;
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}
