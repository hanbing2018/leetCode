package 二叉树;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author hanbing
 * @date 2019-12-28 23:31
 */


//https://leetcode-cn.com/problems/recover-binary-search-tree/
public class _99_恢复二叉搜索树 {

    //推荐方法二


    /**
     * 方法一：中序遍历取出val放入list中，list排序后再次中序遍历将val依次放入节点中。
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        zhongxu(list, root);  //中序遍历取出所有值放入list中


        //用list自带的方法排序
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        });


        zhongxu2(list, root);  //再次中序遍历放入所有的值
    }

    private void zhongxu(List<Integer> list, TreeNode root) {
        if (root == null) return;

        zhongxu(list, root.left);

        list.add(root.val);

        zhongxu(list, root.right);
    }

    private void zhongxu2(List<Integer> list, TreeNode root) {
        if (root == null) return;

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


    /**
     * 方法二：中序遍历树，找出两个错误节点，将两个错误节点的val交换
     */

    //第一个错误节点
    private TreeNode first;
    //第二个错误节点
    private TreeNode second;
    //上一次中序遍历过的节点
    private TreeNode prev;

    public void recoverTree1(TreeNode root) {
        findWrongNodes(root);
        // 交换2个错误节点的值
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void findWrongNodes(TreeNode root) {
        if (root == null) return;
        findWrongNodes(root.left);
        find(root);
        findWrongNodes(root.right);
    }

    private void find(TreeNode node) {
        // 出现了逆序对
        if (prev != null && prev.val > node.val) {
            // 第2个错误节点：最后一个逆序对中较小的那个节点
            second = node;

            // 第1个错误节点：第一个逆序对中较大的那个节点
            if (first != null) return;
            first = prev;
        }
        prev = node;
    }
}
