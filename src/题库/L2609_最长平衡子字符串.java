package 题库;

/**
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 * <p>
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
 * <p>
 * 返回  s 中最长的平衡子字符串长度。
 * <p>
 * 子字符串是字符串中的一个连续字符序列。
 */
public class L2609_最长平衡子字符串 {

    // 思路: 如果为0 需要判断是否是一个全新的0(下标为0 || 前面是不是1)
    //      如果是全新的0 0的数量则置为1
    //      如果不是全新的 0的数量++
    //      如果为1 1的数量++ 更新max的值
    public int findTheLongestBalancedSubstring(String s) {
        int[] arr = new int[2];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                arr[1]++;
                max = Math.max(max, 2 * Math.min(arr[0], arr[1]));
            } else if (i == 0 || s.charAt(i - 1) == '1') {
                arr[0] = 1;
                arr[1] = 0;
            } else {
                arr[0]++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        L2609_最长平衡子字符串 test = new L2609_最长平衡子字符串();

        System.out.println(test.findTheLongestBalancedSubstring("01000111"));
        System.out.println(test.findTheLongestBalancedSubstring("00111"));
        System.out.println(test.findTheLongestBalancedSubstring("111"));
    }
}
