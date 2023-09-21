package 面试经典150题.数组_字符串;

public class L238_除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // left 存储i左侧所有数的乘积
        int[] left = new int[n];
        // right 存储i右侧所有数的乘积
        int[] right = new int[n];

        //{1, 2, 3, 4}

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        // length-1 右侧没有数字, 遍历从length-2开始
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        L238_除自身以外数组的乘积 test = new L238_除自身以外数组的乘积();

        int[] nums = new int[]{1, 2, 3, 4};
        int[] result = test.productExceptSelf(nums);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
