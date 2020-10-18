package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hanbing
 * @date 2020-10-18 19:33
 */

//https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
public class _107_二叉树的层次遍历_II {

    /**
     * 二叉树的层序遍历，每次遍历一行就加入到最终结果list的左边即可
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        queue.offer(root);

        int cur = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            cur--;
            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }

            if (cur == 0) {
                cur = next;
                next = 0;
                res.add(0, list);
                list = new LinkedList<>();
            }
        }

        return res;
    }
}
