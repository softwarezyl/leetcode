package 面试经典150题.区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给定一个  无重复元素 的 有序 整数数组 nums 。
    返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

    列表中的每个区间范围 [a,b] 应该按如下格式输出：
    "a->b" ，如果 a != b
    "a" ，如果 a == b


    示例 1：
    输入：nums = [0,1,2,4,5,7]
    输出：["0->2","4->5","7"]
    解释：区间范围是：
    [0,2] --> "0->2"
    [4,5] --> "4->5"
    [7,7] --> "7"

    示例 2：
    输入：nums = [0,2,3,4,6,8,9]
    输出：["0","2->4","6","8->9"]
    解释：区间范围是：
    [0,0] --> "0"
    [2,4] --> "2->4"
    [6,6] --> "6"
    [8,9] --> "8->9"
 */
public class L228_汇总区间 {

    /**
     * 变相的最长连续子串
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int previousIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果达到边界或者已经不符合递增条件, 则写入结果
            if (i + 1 == nums.length || nums[i] + 1 != nums[i + 1]) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(nums[previousIdx]);
                if (previousIdx != i) {
                    stringBuilder.append("->").append(nums[i]);
                }
                result.add(stringBuilder.toString());
                previousIdx = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L228_汇总区间 test = new L228_汇总区间();

        int[] nums1 = new int[]{0, 1, 2, 4, 5, 7};
        List<String> result1 = test.summaryRanges(nums1);
        System.out.println(result1);
    }
}
