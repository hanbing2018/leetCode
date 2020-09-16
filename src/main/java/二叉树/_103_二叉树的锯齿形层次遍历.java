package 二叉树;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
public class _103_二叉树的锯齿形层次遍历 {

    /**
     * 用两个栈实现二叉树的“之”字型打印，注意不同的行左子节点和右子节点的入栈顺序
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root==null) return res;
        Stack<TreeNode> stackR = new Stack<>();
        Stack<TreeNode> stackL = new Stack<>();
        stackR.push(root);
        TreeNode t;
        while (!stackL.isEmpty() || !stackR.isEmpty()){
            if (!stackR.isEmpty()){
                List<Integer> list = new LinkedList<>();
                while (!stackR.isEmpty()){
                    t = stackR.pop();
                    list.add(t.val);
                    if (t.left!=null){
                        stackL.push(t.left);
                    }
                    if (t.right!=null){
                        stackL.push(t.right);
                    }
                }
                res.add(list);
            }
            if (!stackL.isEmpty()){
                List<Integer> list = new LinkedList<>();
                while (!stackL.isEmpty()){
                    t = stackL.pop();
                    list.add(t.val);
                    if (t.right!=null){
                        stackR.push(t.right);
                    }
                    if (t.left!=null){
                        stackR.push(t.left);
                    }
                }
                res.add(list);
            }
        }
        return res;
    }
}
