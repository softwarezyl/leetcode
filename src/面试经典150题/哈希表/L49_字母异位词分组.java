package 面试经典150题.哈希表;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class L49_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String charsStr = String.valueOf(chars);
            if(map.containsKey(charsStr)){
                List<String> val = map.get(charsStr);
                val.add(s);
                map.put(charsStr, val);
            }else{
                List<String> val = new ArrayList<>();
                val.add(s);
                map.put(charsStr, val);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        L49_字母异位词分组 test = new L49_字母异位词分组();

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = test.groupAnagrams(strs);
        System.out.println(result.toString());
    }
}
