package 剑指offer;


//https://leetcode-cn.com/problems/chou-shu-lcof/
public class _49_丑数 {

    public int nthUglyNumber(int n) {

        //dp
        int a = 0;
        int b = 0;
        int c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int minA = res[a] * 2;
            int minB = res[b] * 3;
            int minC = res[c] * 5;

            res[i] = Math.min(minA, Math.min(minB, minC));
            if (res[i] == minA) {
                a++;
            }
            if (res[i] == minB) {
                b++;
            }
            if (res[i] == minC) {
                c++;
            }

        }

        return res[n - 1];
    }

    public static void main(String[] args) {
        _49_丑数 p = new _49_丑数();
        p.nthUglyNumber(10);
    }
}
