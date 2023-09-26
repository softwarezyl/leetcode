package 面试经典150题.哈希表;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class L128_最长连续序列 {

    /**
     * 哈希表
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int max = 0;
        for (int n : nums) {

            if (!set.contains(n - 1)) {
                int currentMax = 1;
                int currentVal = n;

                while (set.contains(currentVal + 1)) {
                    currentMax++;
                    currentVal = currentVal + 1;
                }
                max = Math.max(currentMax, max);
            }
        }
        return max;
    }

    /**
     * 排序后遍历
     */
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int max = 1;
        int currentMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                currentMax++;
                max = Math.max(currentMax, max);
            } else {
                currentMax = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        L128_最长连续序列 test = new L128_最长连续序列();

        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int result = test.longestConsecutive(nums);
        System.out.println(result);

        int[] nums2 = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int result2 = test.longestConsecutive(nums2);
        System.out.println(result2);

        int[] nums3 = new int[]{1, 2, 0, 1};
        int result3 = test.longestConsecutive(nums3);
        System.out.println(result3);
    }
}
