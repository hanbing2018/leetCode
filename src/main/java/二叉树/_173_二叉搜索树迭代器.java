package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hanbing
 * @date 2019-12-28 23:24
 */

//https://leetcode-cn.com/problems/binary-search-tree-iterator/
public class _173_二叉搜索树迭代器 {

    /**
     * 用一个成员队列实现依次装入树的中序遍历的值，next()方法就是quene.poll   hashNext()方法就是quene.isEmpy
     */

    Queue<Integer> queue = new LinkedList<>();

    public _173_二叉搜索树迭代器(TreeNode root) {
        zhongxu(queue, root);
    }

    private void zhongxu(Queue<Integer> queue, TreeNode root) {
        if (root == null) return;

        zhongxu(queue, root.left);
        queue.offer(root.val);
        zhongxu(queue, root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return queue.poll();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return queue.isEmpty();
    }
}
