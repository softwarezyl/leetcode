package 面试经典150题.数组_字符串;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
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
 */
public class L28_找出字符串中第一个匹配项的下标 {

    public int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) {
            return -1;
        }

        return haystack.indexOf(needle);
    }

    public int strStr2(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;

            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";

        L28_找出字符串中第一个匹配项的下标 test = new L28_找出字符串中第一个匹配项的下标();
        int result = test.strStr(haystack, needle);
        System.out.println(result);
    }
}
