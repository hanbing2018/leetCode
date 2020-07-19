package 剑指offer;


import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
public class _57_II_和为s的连续正数序列 {

    public int[][] findContinuousSequence(int target) {
        List<int[]> list =new LinkedList<>();

        int i = 1;
        int j = 2;
        int sum;

        while (i<j){
            sum = (i + j)*(j - i +1)/2;
            if (sum == target){
                int[] t = new int[j-i+1];
                for (int k = 0; k <=j-i ; k++) {
                    t[k] = k+i;
                }
                list.add(t);
                i++;
                continue;
            }
            if (sum < target){
                j++;
                continue;
            }
            if (sum > target){
                i++;
                continue;
            }

        }

        int[][] res = new int[list.size()][];
        for (int i1 = 0; i1 < list.size(); i1++) {
            res[i1] = list.get(i1);
        }

        return res;
    }
}
