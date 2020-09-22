package 恋上数据结构第三季;


//https://leetcode-cn.com/problems/subtree-of-another-tree/
public class _572_另一个树的子树 {


    public boolean isSubtree(TreeNode s, TreeNode t) {
        //题目已经说明是两个非空二叉树
        StringBuilder ssb = new StringBuilder();
        StringBuilder tsb = new StringBuilder();
        houxu(s, ssb);
        houxu(t, tsb);

        return ssb.toString().contains(tsb.toString());
    }

    //后续遍历拼接字符串
    private void houxu(TreeNode root, StringBuilder sb) {
        if (root.left == null) {
            sb.append("#!");
        } else {
            houxu(root.left, sb);
        }

        if (root.right == null) {
            sb.append("#!");
        } else {
            houxu(root.right, sb);
        }
        sb.append(root.val).append("!");
    }
}
