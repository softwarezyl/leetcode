package 面试经典150题.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * <p>
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class L15_三数之和 {

    /**
     * 排序 + 双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int len = nums.length;
        // 特殊case
        if (nums == null || len < 3) {
            return result;
        }
        // 排序
        Arrays.sort(nums);
        // 遍历数组中的每一个元素
        for (int i = 0; i < len; i++) {
            // 如果起始值就 > 0 则直接退出
            if (nums[i] > 0) {
                break;
            }

            // 如果起始值和前一个元素相等, 跳过, 避免产生重复值
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                // 判断三数之和
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 移动left and right
                    // if left val == right val continue
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L15_三数之和 test = new L15_三数之和();

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = test.threeSum(nums);
        System.out.println(result);
    }
}
