package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-13 16:06
 */

//https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
public class _26_树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null || B==null) return false;
        return hassubtree(A, B);
    }

    private boolean hassubtree(TreeNode a, TreeNode b) {
        if (a==null) return false;

        if (a.val==b.val && equalTree(a, b)) return true;
        if (hassubtree(a.left, b)) return true;
        if (hassubtree(a.right, b)) return true;
        return false;
    }


    private boolean equalTree(TreeNode A, TreeNode B) {
        if (A==null) {
            if (B==null) return true;
            return false;  //A B中只有A为null
        }
        //A B中只有B为null
        if (B==null) return true;

        if (A.val == B.val) {
            return equalTree(A.left, B.left) && equalTree(A.right, B.right);
        }else {
            return false;
        }
    }
}
