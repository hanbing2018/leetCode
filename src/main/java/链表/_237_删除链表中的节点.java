package 链表;

/**
 * @author hanbing
 * @create 2019-12-03 14:04
 */

//https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
public class _237_删除链表中的节点 {
    /**
     * 题目条件已说明非尾结点
     *
     * @param node
     */
    void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
