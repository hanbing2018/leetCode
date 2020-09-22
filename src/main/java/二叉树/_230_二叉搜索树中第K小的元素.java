package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hanbing
 * @date 2019-12-28 23:16
 */

//https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
public class _230_二叉搜索树中第K小的元素 {

    //如果要求第K大的元素，把队列换成栈就可以了
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> queue = new LinkedList<>();
        zhongxu(queue, root);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = queue.poll();
        }

        return ans;
    }

    private void zhongxu(Queue<Integer> queue, TreeNode root) {
        if (root == null) return;

        zhongxu(queue, root.left);

        queue.offer(root.val);

        zhongxu(queue, root.right);
    }


}
