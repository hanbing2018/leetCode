package 剑指offer;

/**
 * @author hanbing
 * @create 2020-04-17 11:59
 */

//https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
public class _33_二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder==null) return false;
        if (postorder.length == 0) return true;
        return veryfiPostorderCore(postorder, 0, postorder.length-1);
    }

    private boolean veryfiPostorderCore(int[] postorder, int start, int end) {
        if (end-start <= 1) return true;
        int index = start;
        while (index<end){
            if (postorder[index] < postorder[end]) {
                index++;
            }else break;
        }
        int indexR = index;  //此时index指向第一个比末尾数大的数，或者指向末尾数
        while (indexR<end){
            if (postorder[indexR] > postorder[end]){
                indexR++;
            }else return false;
        }
        return veryfiPostorderCore(postorder, start, index-1) && veryfiPostorderCore(postorder, index, end-1);
    }
}
