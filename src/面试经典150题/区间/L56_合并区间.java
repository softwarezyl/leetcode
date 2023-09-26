package 面试经典150题.区间;

import java.util.Arrays;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class L56_合并区间 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[][] result = new int[intervals.length][2];
        int idx = -1;
        for (int[] interival : intervals) {
            if (idx == -1 || interival[0] > result[idx][1]) {
                result[++idx] = interival;
            } else {
                result[idx][1] = Math.max(result[idx][1], interival[1]);
            }
        }
        return Arrays.copyOf(result, idx + 1);
    }

    public static void main(String[] args) {
        L56_合并区间 test = new L56_合并区间();

        int[][] nums1 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] nums2 = new int[][]{{1, 10}, {2, 3}, {4, 5}, {6, 7}, {8, 9}};
        int[][] nums3 = new int[][]{{1, 4}, {5, 6}};

        // 0 5
        int[][] nums4 = new int[][]{{0, 2}, {1, 4}, {3, 5}};

        int[][] merge = test.merge(nums4);
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[i].length; j++) {
                System.out.print(merge[i][j] + " ");
            }
            System.out.println();
        }
    }
}
