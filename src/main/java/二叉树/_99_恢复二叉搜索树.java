package 二叉树;

import com.sun.deploy.util.ArrayUtil;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author hanbing
 * @date 2019-12-28 23:31
 */


//https://leetcode-cn.com/problems/recover-binary-search-tree/
public class _99_恢复二叉搜索树 {
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        zhongxu(list, root);  //中序遍历取出所有值放入list中


        //用list自带的方法排序
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2 ? 1:-1;
            }
        });


        zhongxu2(list, root);  //再次中序遍历放入所有的值
    }

    private void zhongxu(List<Integer> list, TreeNode root) {
        if (root==null) return;

        zhongxu(list, root.left);

        list.add(root.val);

        zhongxu(list, root.right);
    }

    private void zhongxu2(List<Integer> list, TreeNode root) {
        if (root==null) return;

        zhongxu2(list, root.left);

        root.val = list.get(0);
        list.remove(0);

        zhongxu2(list, root.right);
    }

    public static void main(String[] args) {
        _99_恢复二叉搜索树 s = new _99_恢复二叉搜索树();

        TreeNode root = new TreeNode(18);
        root.left = new TreeNode(23);
        root.left.left = new TreeNode(-3);
        root.right = new TreeNode(9);

        s.recoverTree(root);
    }
}
