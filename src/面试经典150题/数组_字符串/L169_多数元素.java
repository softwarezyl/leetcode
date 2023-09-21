package 面试经典150题.数组_字符串;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：
 * 输入：nums = [3,2,3]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 */
public class L169_多数元素 {

    // 排序后截取
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

    // 引入Map计数
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.summingInt(e -> 1)));

        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger val = new AtomicInteger();
        map.forEach((k,v) -> {
            if(v > max.get()){
                max.set(v);
                val.set(k);
            }
        });
        return val.get();
    }
}
