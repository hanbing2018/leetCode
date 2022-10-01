package 算法;

/**
 * @author hanbing
 * @date 2019-12-30 23:25
 */

// https://leetcode.cn/problems/nim-game/
public class _292_Nim游戏 {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
