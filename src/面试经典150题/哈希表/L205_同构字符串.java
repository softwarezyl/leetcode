package 面试经典150题.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 */
public class L205_同构字符串 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charC = s.charAt(i);
            char charT = t.charAt(i);

            if (map.containsKey(charC)) {
                if (map.get(charC) != charT) {
                    return false;
                }
            } else {
                map.put(charC, charT);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L205_同构字符串 test = new L205_同构字符串();

        String s3 = "paper";
        String t3 = "title";
        boolean result1 = test.isIsomorphic(s3, t3);
        System.out.println(result1);
    }

}
