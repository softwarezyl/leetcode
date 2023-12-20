package 题库;

import java.util.List;

public class L2828_判别首字母缩略词 {

    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }

        for (int i = 0; i < words.size(); i++) {
            if (i >= s.length()) {
                return false;
            }

            char c = s.charAt(i);
            if (words.get(i).charAt(0) != c) {
                return false;
            }
        }
        return true;
    }

}
