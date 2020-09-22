package 二叉树;

import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hanbing
 * @date 2019-12-27 17:24
 */
public class _判断二叉树是否为完全二叉树 {

    public boolean isWanquan(TreeNode root) {
        if (root == null) return true;  //空二叉树为完全二叉树

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean flag = false; //判断是否应该为叶子节点
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (flag && (node.left != null || node.right != null)) return false;

            if (node.left != null) {
                queue.offer(node.left);
            } else {
                if (node.right != null) return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {
                flag = true;
            }

        }

        return true;
    }
}
