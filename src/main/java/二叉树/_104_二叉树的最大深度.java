package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hanbing
 * @date 2019-12-27 16:56
 */

//https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/

    //这道题是求二叉树的高度
public class _104_二叉树的最大深度 {

    //二叉树的高度
    //方法一：递归
    public int maxDepth(TreeNode root) {
        if (root ==null) return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    //方法二：非递归。层序遍历，树有多少层高度就是多少
    public int maxDepth2(TreeNode root) {
        if (root ==null) return 0;
        int hight = 0;
        int levelSize = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

            levelSize--;
            if (levelSize == 0) {
                hight++;
                levelSize = queue.size();
            }
        }

        return hight;
    }
}


