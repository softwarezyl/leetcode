package 题库;

/*
给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。

示例 1：
输入：low = 3, high = 7
输出：3
解释：3 到 7 之间奇数数字为 [3,5,7] 。

示例 2：
输入：low = 8, high = 10
输出：1
解释：8 到 10 之间奇数数字为 [9] 。

提示：
0 <= low <= high <= 10^9
 */
public class L1523_在区间范围内统计奇数数目 {

    // 暴力法 超时
    public int countOdds(int low, int high) {
        int num = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 != 0) {
                num++;
            }
        }
        return num;
    }

    // high+1/2是区间【0，high】的奇数个数
    // low ~ high 中奇数个数为 (high+1)/2 - low/2
    public int countOdds2(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }

}
