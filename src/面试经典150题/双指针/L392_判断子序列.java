package 面试经典150题.双指针;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * 致谢：
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 */
public class L392_判断子序列 {

    /**
     * 双指针
     */
    public boolean isSubsequence(String s, String t) {
        int sIdx = 0;
        int tIdx = 0;

        while(tIdx < t.length() && sIdx < s.length()){
            if(s.charAt(sIdx) == t.charAt(tIdx)){
                sIdx ++;
            }
            tIdx++;
        }
        return sIdx == s.length();
    }

    public static void main(String[] args) {
        L392_判断子序列 test = new L392_判断子序列();

        String s1 = "abc";
        String t1 = "ahbgdc";
        boolean result1 = test.isSubsequence(s1, t1);
        System.out.println(result1);

        String s2 = "axc";
        String t2 = "ahbgdc";
        boolean result2 = test.isSubsequence(s2, t2);
        System.out.println(result2);

        String s3 = "";
        String t3 = "ahbgdc";
        boolean result3 = test.isSubsequence(s3, t3);
        System.out.println(result3);
    }
}
