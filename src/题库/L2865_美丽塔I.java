package 题库;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。

    你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。

    如果以下条件满足，我们称这些塔是 美丽 的：

    1 <= heights[i] <= maxHeights[i]
    heights 是一个 山脉 数组。
    如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：

    对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
    对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
    请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
 */
public class L2865_美丽塔I {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        // 注意: 每一个都可能作为山峰
        long res = 0;

        for (int peakIdx = 0; peakIdx < maxHeights.size(); peakIdx++) {
            long currentSum = maxHeights.get(peakIdx);

            // 0~i内的单调递增
            int pre = maxHeights.get(peakIdx);
            for (int i = peakIdx - 1; i >= 0; i--) {
                pre = Math.min(pre, maxHeights.get(i));
                currentSum += pre;
            }

            // i~n-1内的单调递减
            int after = maxHeights.get(peakIdx);
            for (int i = peakIdx + 1; i < maxHeights.size(); i++) {
                after = Math.min(after, maxHeights.get(i));
                currentSum += after;
            }
            res = Math.max(currentSum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        L2865_美丽塔I test = new L2865_美丽塔I();

        long result1 = test.maximumSumOfHeights(Arrays.asList(5, 3, 4, 1, 1));
        System.out.println(result1 + " 13");

        long result2 = test.maximumSumOfHeights(Arrays.asList(6, 5, 3, 9, 2, 7));
        System.out.println(result2 + " 22");

        long result3 = test.maximumSumOfHeights(Arrays.asList(3, 2, 5, 5, 2, 3));
        System.out.println(result3 + " 18");

        long result4 = test.maximumSumOfHeights(Arrays.asList(1000000000));
        System.out.println(result4 + " 1000000000");

        long result5 = test.maximumSumOfHeights(Arrays.asList(1000000000, 1000000000, 1000000000));
        System.out.println(result5 + " 3000000000");

        long result6 = test.maximumSumOfHeights(Arrays.asList(3, 6, 3, 5, 5, 1, 2, 5, 5, 6));
        System.out.println(result6 + " 24");

        long result7 = test.maximumSumOfHeights(Arrays.asList(5, 2, 4, 4));
        System.out.println(result7 + " 12");

    }
}
