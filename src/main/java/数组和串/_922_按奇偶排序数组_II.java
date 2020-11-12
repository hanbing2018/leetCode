package 数组和串;

//https://leetcode-cn.com/problems/sort-array-by-parity-ii/
public class _922_按奇偶排序数组_II {

    /**
     * 双指针的解法
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0) return new int[0];

        int ji = 0;
        int ou = 0;
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            //奇数位
            if ((i & 1) == 1) {
                //ji指向下一个奇数
                while ((A[ji] & 1) != 1) {
                    ji++;
                }
                res[i] = A[ji];
                ji++;
            } else {  //偶数位
                while ((A[ou] & 1) != 0) {
                    ou++;
                }
                res[i] = A[ou];
                ou++;
            }
        }
        return res;
    }
}
