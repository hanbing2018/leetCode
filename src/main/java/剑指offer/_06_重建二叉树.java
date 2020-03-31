package 剑指offer;

import sun.java2d.loops.ProcessPath;
import sun.security.util.Length;

import java.util.PrimitiveIterator;

/**
 * @author hanbing
 * @create 2020-03-31 10:30
 */

//https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
public class _06_重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeCore(preorder, 0, preorder.length-1, inorder, 0, inorder.length -1);
    }

    TreeNode buildTreeCore(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn){
        if (startPre > endPre) return null;
        if (startPre==endPre) return new TreeNode(preorder[startPre]);
        int rootInt = preorder[startPre];
        TreeNode root = new TreeNode(rootInt);
        int rootIndexInorder = 0;
        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i]==rootInt) {
                rootIndexInorder = i;  //找到根节点在中序遍历的位置
                break;
            }
        }

        int len = rootIndexInorder - startIn;  //左子树的节点数量
        root.left = buildTreeCore(preorder,startPre+1, startPre+len,inorder, startIn, rootIndexInorder-1);
        root.right = buildTreeCore(preorder,startPre+len+1, endPre,inorder, rootIndexInorder+1, endIn);
        return root;

    }
}
