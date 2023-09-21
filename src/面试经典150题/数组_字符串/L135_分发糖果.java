package 面试经典150题.数组_字符串;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 * 示例 1：
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * <p>
 * 示例 2：
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * <p>
 * 实例3:
 * 输入: rating = [1,3,2,2,1]
 * 输出: 7
 * <p>
 * 实例4: rating = [1,2,87,87,87,2,1]
 * 输出: 13
 * 7 8 9 10 11
 */
public class L135_分发糖果 {

    public int candy(int[] ratings) {
        // TODO


        return 0;
    }


    public static void main(String[] args) {
        L135_分发糖果 test = new L135_分发糖果();

        int[] nums1 = new int[]{1, 0, 2};
        int candy1 = test.candy(nums1);
        System.out.println(candy1);

        int[] nums2 = new int[]{1, 2, 2};
        int candy2 = test.candy(nums2);
        System.out.println(candy2);

        int[] nums3 = new int[]{1, 3, 2, 2, 1};
        int candy3 = test.candy(nums3);
        System.out.println(candy3);
    }
}
