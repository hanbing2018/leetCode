package 链表;

/**
 * @author hanbing
 * @create 2020-04-07 11:31
 */

//https://leetcode-cn.com/problems/add-two-numbers/
public class _2_两数相加 {

    /**
     * 位对齐，依次相加取个位数，保留进位数参与下一位的相加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newsum = new ListNode(-1);
        ListNode tail = newsum;
        int sum = 0;
        int flag = 0;
        ListNode newnode = null;

        while (l1!=null || l2!=null){
            sum = 0;
            if (l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += flag;
            flag = sum/10;
            sum%=10;
            newnode = new ListNode(sum);

                tail.next = newnode;
                tail = newnode;
        }
        if (flag==1){
            tail.next = new ListNode(1);
        }
        return newsum.next;
    }


    private ListNode fanzhuan(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = fanzhuan(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        _2_两数相加 ob =  new _2_两数相加();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(1);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(1);

        ob.addTwoNumbers(l1, l2);
    }
}
