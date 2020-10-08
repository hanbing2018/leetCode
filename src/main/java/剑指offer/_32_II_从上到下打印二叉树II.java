package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hanbing
 * @create 2020-04-16 20:41
 */

//https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
public class _32_II_从上到下打印二叉树II {
    /**
     * 在层序遍历的基础上增加一个当前行的数量和下一行的数量即可
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        //表示当前行的数量
        int curCount = 1;
        //表示下一行的数量
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
                lists.add(list);
                list = new ArrayList<>();
                curCount = nextCount;
                nextCount = 0;
            }

        }
        return lists;
    }
}
