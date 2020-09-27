package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode-cn.com/problems/binary-tree-right-side-view/
public class _199_二叉树的右视图 {

    /**
     * 二叉树层序遍历即可，每次遍历到一层的最后一个就加入到list中
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curNum = 1;
        int nexNum = 0;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            curNum--;
            if (t.left != null) {
                queue.offer(t.left);
                nexNum++;
            }
            if (t.right != null) {
                queue.offer(t.right);
                nexNum++;
            }
            if (curNum == 0) {
                res.add(t.val);
                curNum = nexNum;
                nexNum = 0;
            }
        }
        return res;
    }
}
