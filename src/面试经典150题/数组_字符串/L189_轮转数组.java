package 面试经典150题.数组_字符串;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class L189_轮转数组 {

    /**
     * 引入新数组存储
     */
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            arr[(i + k) % n] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, n);
    }

    /**
     * 环状替换
     * <p>
     * 问题关键在于理解环的个数
     * num.length为偶数时, 会形成多个环 例如1 2 3 4 (1 3 1, 2 4 2, 3 1 3)
     * num.length为奇数时, 会形成1个还 例如 1 2 3 4 5 (1 3 5 2 4 1)
     * <p>
     * 环的个数也就是num.length 和 k的最大公约数
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;

        // 环的个数
        int count = gcd(n, k);

        // 所有的环状都执行完则交换结束
        for (int start = 0; start < count; start++) {
            int current = start;
            int prev = nums[start];

            // 执行替换逻辑
            do {
                // 下一个节点和下一个节点的值
                int nextIdx = (current + k) % n;
                int tmp = nums[nextIdx];

                // 将下一个节点的值替换为上一个节点
                nums[nextIdx] = prev;
                prev = tmp;

                // 重置当前位置
                current = nextIdx;
            } while (start != current);
        }
    }

    // 计算最大公约数
    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }


    public static void main(String[] args) {

    }

}
