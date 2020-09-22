package 剑指offer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author hanbing
 * @date 2020-04-16 23:11
 */

//https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
public class _32_III_从上到下打印二叉树III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) return lists;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> list = null;

        stack1.add(root);
        while (!stack1.empty() || !stack2.empty()) {
            list = new ArrayList<>();
            while (!stack1.empty()) {
                TreeNode pop = stack1.pop();
                list.add(pop.val);
                if (pop.left != null) stack2.push(pop.left);
                if (pop.right != null) stack2.push(pop.right);
            }
            if (list.size() > 0) lists.add(list);
            list = new ArrayList<>();
            while (!stack2.empty()) {
                TreeNode pop = stack2.pop();
                list.add(pop.val);
                if (pop.right != null) stack1.push(pop.right);
                if (pop.left != null) stack1.push(pop.left);
            }
            if (list.size() > 0) lists.add(list);
        }
        return lists;
    }
}
