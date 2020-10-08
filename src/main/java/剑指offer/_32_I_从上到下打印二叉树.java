package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hanbing
 * @create 2020-04-16 16:16
 */

//https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
public class _32_I_从上到下打印二叉树 {

    /**
     * 就是二叉树的层序遍历而已
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        int curCount = 1;
        int nextCount = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.val);
            curCount--;
            if (poll.left != null) {
                queue.offer(poll.left);
                nextCount++;
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                nextCount++;
            }
            if (curCount == 0) {
                curCount = nextCount;
                nextCount = 0;
            }

        }
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
