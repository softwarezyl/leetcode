package 面试经典150题.哈希表;

import java.util.HashMap;
import java.util.Map;

/*
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

    示例 1:
    输入: s = "anagram", t = "nagaram"
    输出: true

    示例 2:
    输入: s = "rat", t = "car"
    输出: false

    提示:
    1 <= s.length, t.length <= 5 * 104
    s 和 t 仅包含小写字母
 */
public class L242_有效的字母异位词 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            int val = map.getOrDefault(c, 0);
            map.put(c, val + 1);
        }

        for (Character c : t.toCharArray()) {
            if (map.containsKey(c)) {
                int val = map.get(c);
                if (val < 1) {
                    return false;
                } else {
                    map.put(c, val - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
