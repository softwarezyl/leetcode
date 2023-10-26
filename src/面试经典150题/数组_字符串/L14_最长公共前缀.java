package 面试经典150题.数组_字符串;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class L14_最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        int idx = 0;
        String world = strs[0];

        while (idx < world.length()) {
            String s = world.substring(0, idx + 1);

            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(s)) {
                    return world.substring(0, idx);
                }
            }
            idx++;
        }
        if(idx == world.length()){
            return world;
        }
        return "";
    }

    public static void main(String[] args) {
        L14_最长公共前缀 test = new L14_最长公共前缀();

        String[] s = new String[]{"flower","flow","flight"};
        String result = test.longestCommonPrefix(s);
        System.out.println(result);

        String[] s2 = new String[]{"dog","racecar","car"};
        String result2 = test.longestCommonPrefix(s2);
        System.out.println(result2);

        String[] s3 = new String[]{"a"};
        String result3 = test.longestCommonPrefix(s3);
        System.out.println(result3);

        String[] s4 = new String[]{"flower","flower","flower","flower"};
        String result4 = test.longestCommonPrefix(s4);
        System.out.println(result4);
    }
}
