package 面试经典150题.区间;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * <p>
 * 示例 1：
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 * <p>
 * 示例 2：
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 * <p>
 * 示例 3：
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
 */
public class L452_用最少数量的箭引爆气球 {

    public int findMinArrowShots(int[][] points) {
        int n = points.length;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        int currentPoint = points[0][1];
        int result = 1;
        for (int i = 1; i < n; i++) {
            if (currentPoint < points[i][0]) {
                currentPoint = points[i][1];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L452_用最少数量的箭引爆气球 test = new L452_用最少数量的箭引爆气球();

        int[][] points1 = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int result1 = test.findMinArrowShots(points1);
        System.out.println(result1);

        int[][] points2 = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int result2 = test.findMinArrowShots(points2);
        System.out.println(result2);

        int[][] points3 = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int result3 = test.findMinArrowShots(points3);
        System.out.println(result3);
    }
}
