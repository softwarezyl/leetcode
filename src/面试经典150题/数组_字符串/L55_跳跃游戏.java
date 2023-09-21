package 面试经典150题.数组_字符串;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class L55_跳跃游戏 {

    /**
     *  贪心算法
     *
     *  只要存在可到达位置x 并且x + nums[x] > y 那么位置y也可以到达
     *  维护一个最远可到达的值, 如果最远可到达的值, 大于最后一个位置, 那么最后一个位置就是可达的.
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;

        for (int i = 0; i < n; i++) {
            // i<=rightMost是为了判断下一个坐标是否是可达坐标
            if (i <= rightMost) {
                rightMost = Math.max(i + nums[i], rightMost);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L55_跳跃游戏 test = new L55_跳跃游戏();

        int[] nums = new int[]{0};
        boolean result = test.canJump(nums);
        System.out.println(result);
    }
}
