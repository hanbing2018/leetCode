package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-13 16:06
 */

//https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
public class _26_树的子结构 {
    /**
     * 用两层递归可以实现，原理简单：
     * 第一层递归：a和b树相同，返回true，否则递归判断a的左右子树是否与b相等
     * 第二层递归：相等的操作也是递归实现的，判断根节点是否相等，再递归判断左右子树是否相等
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //如果A或B为空，则返回false
        if (A == null || B == null) return false;
        return hassubtree(A, B);
    }

    //判断树A是否包含树B的结构
    private boolean hassubtree(TreeNode a, TreeNode b) {
        if (a == null) return false;
        return contains(a, b) || hassubtree(a.left, b) || hassubtree(a.right, b);
    }

    //判断树A从根节点开始是否包含树B的结构
    private boolean contains(TreeNode A, TreeNode B) {
        if (A == null) {
            if (B == null) return true;
            return false;  //A B中只有A为null
        }
        //A B中只有B为null
        if (B == null) return true;

        if (A.val == B.val) {
            return contains(A.left, B.left) && contains(A.right, B.right);
        } else {
            return false;
        }
    }
}
