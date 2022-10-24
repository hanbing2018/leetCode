package 算法;

/**
 * @author hanbing
 * @date 2022-10-23 6:53
 */

// https://leetcode.cn/problems/compare-version-numbers/
public class _165_比较版本号 {

    public int compareVersion(String version1, String version2) {
        String[] strings1 = version1.split("\\.");
        System.out.println(strings1);
        String[] strings2 = version2.split("\\.");
        System.out.println(strings2);

        int len = Math.max(strings1.length, strings2.length);

        for (int i = 0; i < len; i++) {
            int ver1 = i < strings1.length ? Integer.parseInt(strings1[i]) : 0;
            int ver2 = i < strings2.length ? Integer.parseInt(strings2[i]) : 0;
            System.out.println(ver1);;
            System.out.println(ver2);;
            if (ver1 > ver2) {
                return 1;
            }
            if (ver1 < ver2) {
                return -1;
            }

        }

        return 0;
    }
}
