package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hanbing
 * @date 2019-12-28 19:24
 */

//https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/comments/
public class _783_二叉搜索树结点最小距离 {
    public int minDiffInBST(TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();

        //中序遍历
        zhongxu(queue, root);  //讲各个节点按小大的顺序进入队列
        int min = Integer.MAX_VALUE;
        Integer t1 = queue.poll();
        Integer t2;
        while ((t2=queue.poll())!=null){
            min = Math.min(min, t2-t1);
            t1=t2;
        }
        return min;
    }

    private void zhongxu(Queue<Integer> queue, TreeNode root) {
        if (root==null) return;

        zhongxu(queue, root.left);

        queue.offer(root.val);

        zhongxu(queue, root.right);
    }
}
