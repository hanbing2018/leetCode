package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author hanbing
 * @date 2020-10-06 20:35
 */

//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
public class _94_二叉树的中序遍历 {

    /**
     * 二叉树的 非递归 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                //将当前节点入栈
                stack.push(cur);
                //往左走
                cur = cur.left;
            } else if (stack.isEmpty()) {
                break;
            } else {
                //左边走到底了，访问栈顶的元素
                cur = stack.pop();
                res.add(cur.val);
                //往右走
                cur = cur.right;
            }
        }
        return res;
    }
}
