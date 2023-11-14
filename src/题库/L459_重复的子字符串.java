package 题库;

public class L459_重复的子字符串 {

    // 解法: 如果s存在于掐头去尾的s+s串中 即可以从子串重复构成
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
