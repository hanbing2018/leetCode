package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-17 11:59
 */

//https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
public class _33_二叉搜索树的后序遍历序列 {

    /**
     * 递归判断。
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        //题目要求，空数组，返回true
        if (postorder.length == 0) return true;
        return veryfiPostorderCore(postorder, 0, postorder.length - 1);
    }

    private boolean veryfiPostorderCore(int[] postorder, int start, int end) {
        //只有一个节点或没有节点，则返回true
        if (end - start <= 1) return true;
        int index = start;
        // postorder[end]为root节点的值，从start开始寻找第一个大于等于根节点的节点
        while (index < end) {
            if (postorder[index] < postorder[end]) {
                index++;
            } else break;
        }
        int indexR = index;  //此时index指向第一个比根节点大的数，或者指向根节点

        //判断从indexR到end-1是否都比根节点大，如果不是则返回false
        //如果indexR恰好是end，则会跳过循环
        while (indexR < end) {
            if (postorder[indexR] > postorder[end]) {
                indexR++;
            } else return false;
        }
        //判断左边序列和右边序列是否都是后序遍历
        return veryfiPostorderCore(postorder, start, index - 1) && veryfiPostorderCore(postorder, index, end - 1);
    }
}
