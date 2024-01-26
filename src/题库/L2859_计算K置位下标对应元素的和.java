package 题库;

import java.util.List;

public class L2859_计算K置位下标对应元素的和 {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (bitCount(i) == k) {
                result += nums.get(i);
            }
        }
        return result;
    }

    private int bitCount(int x) {
        int cnt = 0;

        while (x != 0) {
            cnt += (x % 2);
            x = x / 2;
        }
        return cnt;
    }
}