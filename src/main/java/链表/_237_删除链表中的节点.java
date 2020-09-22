package 链表;

/**
 * @author hanbing
 * @create 2019-12-03 14:04
 */
public class _237_删除链表中的节点 {
    /**
     * Definition for singly-linked list.
     * struct ListNode {
     * int val;
     * ListNode *next;
     * ListNode(int x) : val(x), next(NULL) {}
     * };
     */

    //https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
    void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
