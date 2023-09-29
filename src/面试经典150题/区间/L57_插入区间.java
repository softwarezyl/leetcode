package 面试经典150题.区间;

import java.util.ArrayList;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * <p>
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 示例 3：
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * <p>
 * 示例 4：
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * <p>
 * 示例 5：
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 */
public class L57_插入区间 {

    /**
     * 不重叠，需满足：绿区间的右端，位于蓝区间的左端的左边，如 [1,2]。
     * <p>
     * 则当前绿区间，推入 res 数组，指针 +1，考察下一个绿区间。
     * 循环结束时，当前绿区间的屁股，就没落在蓝区间之前，有重叠了，如 [3,5]。
     * 现在看重叠的。我们反过来想，没重叠，就要满足：绿区间的左端，落在蓝区间的屁股的后面，反之就有重叠：绿区间的左端 <= 蓝区间的右端，极端的例子就是 [8,10]。
     * <p>
     * 和蓝有重叠的区间，会合并成一个区间：左端取蓝绿左端的较小者，右端取蓝绿右端的较大者，不断更新给蓝区间。
     * 循环结束时，将蓝区间（它是合并后的新区间）推入 res 数组。
     * 剩下的，都在蓝区间右边，不重叠。不用额外判断，依次推入 res 数组。
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int len = intervals.length;
        int i = 0;

        // 判断左边不重合 即已有数组的右侧值要小于 新数组的左边的值, 才会不重合
        while (i < len && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 判断重合部分
        while (i < len && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        // 判断右边没重叠的部分
        while (i < len && intervals[i][0] > newInterval[1]) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[0][]);
    }
}
