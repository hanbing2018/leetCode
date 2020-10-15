package 二叉树;


import java.util.*;

//https://leetcode-cn.com/problems/diameter-of-binary-tree/
public class _543_二叉树的直径 {

    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return result;
        depth2(root);
        return result;
    }

    /**
     * 递归求二叉树的深度
     *
     * @param root
     * @return
     */
    private int depth2(TreeNode root) {
        if (root == null) return 0;
        //res记录以当前节点为根节点的树的高度
        int res = 0;
        int ldep = depth2(root.left);
        int rdep = depth2(root.right);
        res = 1 + Math.max(ldep, rdep);
        result = Math.max(result, ldep + rdep);
        return res;
    }

    /**
     * 求二叉树的深度
     *
     * @param root
     * @return
     */
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curNum = 1;
        int nextNum = 0;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            curNum--;
            if (t.left != null) {
                queue.offer(t.left);
                nextNum++;
            }
            if (t.right != null) {
                queue.offer(t.right);
                nextNum++;
            }
            if (curNum == 0) {
                res++;
                curNum = nextNum;
                nextNum = 0;
            }
        }
        return res;
    }
}
