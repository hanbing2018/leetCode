package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hanbing
 * @date 2019-12-28 17:46
 */


//https://leetcode-cn.com/problems/validate-binary-search-tree/
public class _98_验证二叉搜索树 {

    /**
     * 对二叉树进行中序遍历，把val放入有序list中，依次取出list中的元素查看是否是单调递增即可
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();

        if (root == null) return true;  //空树

        //中序遍历
        zhongxu(queue, root);
        int t1 = queue.poll();
        Integer t2;
        while ((t2 = queue.poll()) != null) {
            if (t2 <= t1) return false;
            t1 = t2;
        }

        return true;
    }

    private void zhongxu(Queue<Integer> queue, TreeNode root) {
        if (root == null) return;

        zhongxu(queue, root.left);

        queue.offer(root.val);

        zhongxu(queue, root.right);
    }
}
