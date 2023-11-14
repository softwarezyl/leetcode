package 题库;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 */
public class L389_找不同 {

    // 方法1: 哈希表
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> exists = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (exists.containsKey(c)) {
                exists.put(c, exists.get(c) + 1);
            } else {
                exists.put(c, 1);
            }
        }

        for (Character c : t.toCharArray()) {
            if (!exists.containsKey(c)) {
                return c;
            }
            if (exists.get(c) == 1) {
                exists.remove(c);
            } else {
                exists.put(c, exists.get(c) - 1);
            }


        }
        return 0;
    }

    // 方法2: 求和
    public char findTheDifference2(String s, String t) {
        int sSum = 0;
        for (char c : s.toCharArray()) {
            sSum += c;
        }

        int tSum = 0;
        for (char c : t.toCharArray()) {
            tSum += c;
        }
        return (char) (tSum - sSum);
    }

    public static void main(String[] args) {
        L389_找不同 test = new L389_找不同();

        char result = test.findTheDifference2("a", "aa");
        System.out.println(result);
    }
}
