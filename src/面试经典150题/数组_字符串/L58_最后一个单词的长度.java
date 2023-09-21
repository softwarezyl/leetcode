package 面试经典150题.数组_字符串;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 *
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 *
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 */
public class L58_最后一个单词的长度 {

    public int lengthOfLastWord(String s) {
        String[] worlds = s.split(" ");

        int n = worlds.length;
        if(worlds[n-1].equals(" ")){
            return worlds[n-2].length();
        }
        return worlds[n-1].length();
    }

    public static void main(String[] args) {
        String s = "Hello World";

        L58_最后一个单词的长度 test = new L58_最后一个单词的长度();
        int result = test.lengthOfLastWord(s);
        System.out.println(result);
    }
}
