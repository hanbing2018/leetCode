package 恋上数据结构第三季;

import java.util.Stack;

/**
 * @author hanbing
 * @date 2020-10-14 20:45
 */

//https://leetcode-cn.com/problems/daily-temperatures/
public class _739_每日温度 {

    /**
     * 方法一：dp算法
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        if (T.length == 1) return new int[1];
        int[] res = new int[T.length];

        for (int i = T.length - 2; i >= 0; i--) {
            //j的初始值为i+1
            int j = i + 1;
            while (true) {
                if (T[i] < T[j]) { //如果第i天温度小于第j天温度
                    res[i] = j - i;
                    break;
                } else if (T[i] > T[j]) {//如果第i天温度大于第j天温度
                    if (res[j] == 0) {
                        res[i] = 0;
                        break;
                    } else {
                        j += res[j];
                    }
                } else { //如果第i天温度等于第j天温度
                    if (res[j] == 0) {
                        res[i] = 0;
                        break;
                    } else {
                        res[i] = res[j] + j - i;
                        break;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 方法二：利用栈求出右边第一个比它大的数
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures2(int[] T) {
        if (T.length == 1) return new int[1];
        int[] res = new int[T.length];

        //stack存储索引值
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
