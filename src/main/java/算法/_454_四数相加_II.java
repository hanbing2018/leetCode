package 算法;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//https://leetcode-cn.com/problems/4sum-ii/
public class _454_四数相加_II {

    /**
     * 两个map，分别存储A+B、C+D的和与和的次数，遍历mapAB，在mapCD中有相应的-key，将val相乘为
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //mapAB存储AB和为key，和的次数为val
        Map<Integer, Integer> mapAB = new HashMap<>();
        Map<Integer, Integer> mapCD = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int i1 = 0; i1 < B.length; i1++) {
                int sum = A[i] + B[i1];
                mapAB.put(sum, mapAB.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int i1 = 0; i1 < D.length; i1++) {
                int sum = C[i] + D[i1];
                mapCD.put(sum, mapCD.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        Set<Map.Entry<Integer, Integer>> entries = mapAB.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int key2 = -entry.getKey();
            Integer val2 = mapCD.get(key2);
            if (val2 != null) {
                res += entry.getValue() * val2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _454_四数相加_II p = new _454_四数相加_II();
        int var = p.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0});
        System.out.println(var);
    }

    /**
     * 最容易想到的最笨的方法，结果正确，但是超时
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            for (int i1 = 0; i1 < B.length; i1++) {
                for (int i2 = 0; i2 < C.length; i2++) {
                    for (int i3 = 0; i3 < D.length; i3++) {
                        if (A[i] + B[i1] + C[i2] + D[i3] == 0) num++;
                    }
                }
            }
        }
        return num;
    }
}
