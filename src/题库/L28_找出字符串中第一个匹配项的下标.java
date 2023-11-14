package 题库;

/**
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * <p>
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * <p>
 * 提示：
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 */
public class L28_找出字符串中第一个匹配项的下标 {

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i + n <= m; i++) {
            boolean match = true;

            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        L28_找出字符串中第一个匹配项的下标 test = new L28_找出字符串中第一个匹配项的下标();

        System.out.println(test.strStr("sadbutsad", "sad"));
        System.out.println(test.strStr("leetcode", "leeto"));
        System.out.println(test.strStr("a", "a"));
    }
}
