package 剑指offer;


//https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
public class _45_把数组排成最小的数 {

    //解法一
    public String minNumber(int[] nums) {
        if (nums.length==0) return "";
        mySort(nums, 0, nums.length-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }

        return sb.toString();
    }

    public void mySort(int[] nums, int lIndex, int rIndex){
        if (lIndex >= rIndex) return;
        //快速排序

        int i = lIndex + 1;
        int j = rIndex;
        while (true){
            while (i<=rIndex && comp(nums[i], nums[lIndex])<0) i++;
            while (j>=lIndex+1 && comp(nums[j], nums[lIndex])>0) j--;
            if (i<j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }else break;
        }
        int t = nums[lIndex];
        nums[lIndex] = nums[j];
        nums[j] = t;
        mySort(nums, lIndex, j-1);
        mySort(nums, j+1, rIndex);
    }

    public int comp(int num1, int num2){
        String str1 = String.valueOf(num1) + num2;
        String str2 = String.valueOf(num2) + num1;

        return str1.compareTo(str2);
    }

    //解法二
    public String minNumber2(int[] nums) {
        if (nums.length==0) return "";

        //优化：将整数数组转化为字符串数组可加快速度
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }
        mySort2(numsStr, 0, numsStr.length-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(numsStr[i]);
        }
        return sb.toString();
    }

    public void mySort2(String[] numsStr, int lIndex, int rIndex){
        if (lIndex >= rIndex) return;
        //快速排序

        int i = lIndex + 1;
        int j = rIndex;
        while (true){
            while (i<=rIndex && (numsStr[i]+numsStr[lIndex]).compareTo(numsStr[lIndex]+numsStr[i])<0) i++;
            while (j>=lIndex+1 && (numsStr[j]+numsStr[lIndex]).compareTo(numsStr[lIndex]+numsStr[j])>0) j--;
            if (i<j){
                String t = numsStr[i];
                numsStr[i] = numsStr[j];
                numsStr[j] = t;
                i++;
                j--;
            }else break;
        }
        String t = numsStr[lIndex];
        numsStr[lIndex] = numsStr[j];
        numsStr[j] = t;
        mySort2(numsStr, lIndex, j-1);
        mySort2(numsStr, j+1, rIndex);
    }
}
