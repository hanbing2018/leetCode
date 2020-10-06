package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author hanbing
 * @date 2020-10-06 20:26
 */
//https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
public class _144_二叉树的前序遍历 {

    /**
     * 二叉树的前序遍历，非递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            if (cur != null) {
                //遍历当前节点
                res.add(cur.val);
                //将右子节点加入栈
                if (cur.right != null) stack.push(cur.right);
                cur = cur.left;
            } else if (stack.isEmpty()) {
                //遍历完了
                break;
            } else {
                cur = stack.pop();
            }
        }

        return res;
    }
}
