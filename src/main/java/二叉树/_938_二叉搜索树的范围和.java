package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hanbing
 * @date 2019-12-28 20:04
 */

//https://leetcode-cn.com/problems/range-sum-of-bst/submissions/
public class _938_二叉搜索树的范围和 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        Queue<Integer> queue = new LinkedList<>();

        zhongxu(queue, root);
        int sum = 0;
        Integer t;
        while ((t=queue.poll())!=null){
            if (t>=L && t<=R) sum += t;
        }
        return sum;
    }

    private void zhongxu(Queue<Integer> queue, TreeNode root) {
        if (root==null) return;

        zhongxu(queue, root.left);

        queue.offer(root.val);

        zhongxu(queue, root.right);
    }
}
