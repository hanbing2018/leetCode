package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hanbing
 * @create 2020-04-13 18:28
 */

//https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
public class _28_对称的二叉树 {

    /**
     * 方法一：递归
     * 递归判断左右两个子树是否相等即可
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; //此题中规定root为null时为对称的
        return isTwoTreeSymmetric(root.left, root.right);
    }


    //判断两个二叉树是否对称
    private boolean isTwoTreeSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;  //其中一个为null，则肯定不对称

        if (left.val != right.val) return false;  //根节点的值不一样，则不对称
        return isTwoTreeSymmetric(left.left, right.right) && isTwoTreeSymmetric(left.right, right.left);
    }


    /**
     * 方法二：迭代（非递归）
     * 初始化时我们把根节点入队两次。每次提取两个结点并比较它们的值（队列中每两个连续的结点应该是相等的，
     * 而且它们的子树互为镜像），然后将两个结点的左右子结点按相反的顺序插入队列中。当队列为空时，
     * 或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
     *
     * @param root
     * @return
     */

    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }


}
