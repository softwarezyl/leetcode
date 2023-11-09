package 题库;

import java.util.HashSet;
import java.util.Set;

public class L2586_统计范围内的元音字符串数 {

    public int vowelStrings(String[] words, int left, int right) {
        int result = 0;

        Set<Character> vowelChar = new HashSet<>();
        vowelChar.add('a');
        vowelChar.add('e');
        vowelChar.add('i');
        vowelChar.add('o');
        vowelChar.add('u');

        for (int i = left; i <= right; i++) {
            String word = words[i];

            if (vowelChar.contains(word.charAt(0)) && vowelChar.contains(word.charAt(word.length() - 1))) {
                result++;
            }
        }
        return result;
    }
}
