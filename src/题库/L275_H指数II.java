package 题库;

/**
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
 * <p>
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）至少 有 h 篇论文分别被引用了至少 h 次。
 * <p>
 * 请你设计并实现对数时间复杂度的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：citations = [0,1,3,5,6]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 * 由于研究者有3篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3 。
 * 示例 2：
 * <p>
 * 输入：citations = [1,2,100]
 * 输出：2
 */
public class L275_H指数II {

    public int hIndex(int[] citations) {
        int hVal = 0;
        int n = citations.length - 1;

        while (n >= 0 && citations[n] > hVal) {
            hVal++;
            n--;
        }
        return hVal;
    }

    // 二分法
    public int hIndex2(int[] citations) {
        int left = 0;
        int right = citations.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (citations[mid] >= citations.length - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
