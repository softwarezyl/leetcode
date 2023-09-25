package 面试经典150题.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * <p>
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * <p>
 * 示例 1：
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 * <p>
 * 示例 2：
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 * 所以我们返回一个空数组。
 * <p>
 * 示例 3：
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
 */
public class L30_串联所有单词的子串 {

    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        int distance = words.length * wordLength;
        if (s.length() < distance) {
            return new ArrayList<>();
        }

        Map<String, Integer> allWordsMap = new HashMap<>();
        for (String str : words) {
            int val = allWordsMap.getOrDefault(str, 0);
            allWordsMap.put(str, val + 1);
        }

        int left = 0;
        int right = left + distance;

        List<Integer> result = new ArrayList<>();

        while (right <= s.length()) {
            String current = s.substring(left, right);
            Map<String, Integer> usedWorld = new HashMap<>();
            int num = 0;
            for (int i = 0; i < current.length(); i += wordLength) {
                String tmp = current.substring(i, i + wordLength);
                if (!allWordsMap.containsKey(tmp)) {
                    break;
                } else {
                    int val = usedWorld.getOrDefault(tmp, 0);
                    usedWorld.put(tmp, val+1);
                    if (usedWorld.get(tmp) > allWordsMap.get(tmp)) {
                        break;
                    }
                }
                num ++;
            }
            if (num == words.length) {
                result.add(left);
            }

            left ++;
            right = left + distance;
        }
        return result;
    }

    public static void main(String[] args) {
        L30_串联所有单词的子串 test = new L30_串联所有单词的子串();

        String s = "barfoofoobarthefoobarman";
        String[] words = new String[]{"bar", "foo", "the"};
        List<Integer> substring = test.findSubstring(s, words);
        System.out.println(substring.toString());

        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = new String[]{"word", "good", "best", "good"};
        List<Integer> substring2 = test.findSubstring(s2, words2);
        System.out.println(substring2.toString());

        String s3 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words3 = new String[]{"fooo","barr","wing","ding","wing"};
        List<Integer> substring3 = test.findSubstring(s3, words3);
        System.out.println(substring3.toString());

        String s4 = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
        String[] words4 = new String[] {"ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","ab","bc"};
        List<Integer> substring4 = test.findSubstring(s4, words4);
        System.out.println(substring4.toString());
    }

}
