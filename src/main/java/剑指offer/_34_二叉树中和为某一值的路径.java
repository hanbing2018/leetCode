package 剑指offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hanbing
 * @create 2020-04-17 12:44
 */

//https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
public class _34_二叉树中和为某一值的路径 {
    LinkedList<List<Integer>> lists = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSumCore(root, sum);
        return lists;
    }

    private void pathSumCore(TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        sum-=root.val;
        if (root.left==null && root.right==null && sum==0){
            lists.add(new LinkedList<>(list));
        }
        pathSumCore(root.left, sum);
        pathSumCore(root.right, sum);
        list.removeLast();
    }

}
