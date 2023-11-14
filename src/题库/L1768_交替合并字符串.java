package 题库;

/**
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 * <p>
 * 示例 1：
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 * <p>
 * 示例 2：
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 * <p>
 * 示例 3：
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q
 * 合并后：  a p b q c   d
 */
public class L1768_交替合并字符串 {

    public String mergeAlternately(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2;
        }
        if (word2 == null || word1.length() == 0) {
            return word1;
        }
        int idx1 = 0, idx2 = 0;
        StringBuilder str = new StringBuilder();
        while (idx1 < word1.length() && idx2 < word2.length()) {
            str.append(word1.charAt(idx1++));
            str.append(word2.charAt(idx2++));
        }

        if (idx1 != word1.length()) {
            str.append(word1.substring(idx1));
        }
        if (idx2 != word2.length()) {
            str.append(word2.substring(idx2));
        }
        return str.toString();
    }

    public static void main(String[] args) {
        L1768_交替合并字符串 test = new L1768_交替合并字符串();

        System.out.println(test.mergeAlternately("abc", "pqr"));
        System.out.println(test.mergeAlternately("ab", "pqrs"));
        System.out.println(test.mergeAlternately("abcd", "pq"));
    }
}
