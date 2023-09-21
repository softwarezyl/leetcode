package 面试经典150题.数组_字符串;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * <p>
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 */
public class L45_跳跃游戏II {

    public int jump(int[] nums) {
        // 能跳跃的最远位置
        int maxPos = 0;
        // 步数
        int step = 0;

        // 上次跳跃可以到的右边界
        int end = 0;

        // 注意: 我们不需要访问最后一个元素, 因为在访问最后一个元素之前, 我们的边界一定大于等于最后一个位置, 否则是无法跳到最后一个位置的
        for (int i = 0; i < nums.length; i++) {
            maxPos = Math.max(i + nums[i], maxPos);

            // 如果到达了上次能跳跃的最右边界
            if (i == end) {
                end = maxPos;
                step ++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        L45_跳跃游戏II test = new L45_跳跃游戏II();

        int[] nums = new int[]{2, 3, 1, 1, 4};
        int result = test.jump(nums);
        System.out.println(result);
    }
}
