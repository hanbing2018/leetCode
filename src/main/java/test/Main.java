package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanbing
 * @date 2022-11-25 22:53
 */
public class Main {

    public static void main(String[] args) {
        generate(5);

    }


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        list.add(1);
        res.add(list);
        list = new ArrayList<>();

        for(int i = 1;i < numRows;i++) {

            list.add(1);
            List<Integer> temList = res.get(i - 1);
            for(int j = 0;j < temList.size() - 1;j++) {
                list.add(temList.get(j) + temList.get(j + 1));
            }
            list.add(1);

            res.add(new ArrayList<>(list));
            list = new ArrayList<>();
        }

        return res;
    }

    public static int myAtoi(String s) {
        char[] chars = s.toCharArray();

        int res = 0;
        int flag = 1;
        int i = 0;
        while(i < chars.length) {
            if(chars[i] == ' ') {
                i++;
                continue;
            }

            if (chars[i] == '+') continue;
            if (chars[i] == '-') {
                flag = -1;
                continue;
            }
            if (chars[i] < '0' || chars[i] > '9') break;

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && chars[i] - '0' > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && chars[i] - '0' > -Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + flag * (chars[i] - '0');
            i++;
        }

        return res;
    }

    public static int countPrimes(int n) {
        if(n == 0 || n == 1 || n == 2) return 0;
        int res = 1; // 2
        int i = 3;
        while(i < n && priNum(i)) {
            res++;
            i++;
        }

        return res;


    }

    private static boolean priNum(int n){ // n >= 3
        for (int i = 2; i * i <= n;i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
