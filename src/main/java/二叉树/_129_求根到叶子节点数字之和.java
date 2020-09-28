package 二叉树;


import java.util.LinkedList;
import java.util.Queue;

//https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
public class _129_求根到叶子节点数字之和 {

    /**
     * 方法一：dfs，如果当前节点时叶子节点就返回值，如果不是就返回递归调用返回左子节点和右子节点的值。
     * 一个节点的值等于 父节点的值*10 + 本节点.val
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
//        return bfs(root);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        // sum表示父节点的值
        sum = sum * 10 + root.val;
        //如果当前节点是叶子节点，则返回值
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            //如果不是叶子节点
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    /**
     * 方法二：bfs，用两个队列，一个存储节点，一个存储节点的值。
     * 层序遍历，如果是叶子节点就将节点的值加入最终结果
     *
     * @param root
     * @return
     */
    private int bfs(TreeNode root) {
        if (root == null) return 0;
        //保存最终的结果
        int res = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        //保存每个节点的值
        Queue<Integer> valQueue = new LinkedList<>();
        int curNum = 1;
        int nextNum = 0;
        nodeQueue.offer(root);
        valQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode t = nodeQueue.poll();
            int nodeval = valQueue.poll();
            curNum--;
            if (t.left != null) {
                nodeQueue.offer(t.left);
                valQueue.offer(nodeval * 10 + t.left.val);
                nextNum++;
            }
            if (t.right != null) {
                nodeQueue.offer(t.right);
                valQueue.offer(nodeval * 10 + t.right.val);
                nextNum++;
            }
            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
            }
            //如果是叶子节点则计算该节点的值
            if (t.left == null && t.right == null) res += nodeval;
        }
        return res;
    }
}
