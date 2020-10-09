package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author hanbing
 * @date 2020-10-06 21:17
 */

//https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
public class _145_二叉树的后序遍历 {

    /**
     * 二叉树的 非递归 后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        //记录上一个被遍历的节点
        TreeNode pre = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (isLeaf(cur) || isChild(pre, cur)) {
                cur = stack.pop();
                //访问当前节点
                res.add(cur.val);
                pre = cur;
            } else {
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            }
        }
        return res;
    }

    private boolean isChild(TreeNode pre, TreeNode cur) {
        if (pre != null && (cur.left == pre || cur.right == pre)) return true;
        return false;
    }


    private boolean isLeaf(TreeNode cur) {
        if (cur.left == null && cur.right == null) return true;
        return false;
    }
}
