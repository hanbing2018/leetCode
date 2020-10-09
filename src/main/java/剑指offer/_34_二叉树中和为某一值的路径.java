package 剑指offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hanbing
 * @create 2020-04-17 12:44
 */

//https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
public class _34_二叉树中和为某一值的路径 {
    //存储最终的结果
    LinkedList<List<Integer>> lists = new LinkedList<>();
    //存储每次遍历到叶子节点的结果
    LinkedList<Integer> list = new LinkedList<>();

    /**
     * 前序遍历，本质上还是dfs。注意要还原现场
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSumCore(root, sum);
        return lists;
    }

    private void pathSumCore(TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            lists.add(new LinkedList<>(list));
        }
        pathSumCore(root.left, sum);
        pathSumCore(root.right, sum);
        //还原现场
        list.removeLast();
    }

}
