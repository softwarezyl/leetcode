package 题库;

public class L709_转换成小写字母 {

    // 使用Java自带方法
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    // 大写字母 A-Z 的ascii码的范围害是65,90
    // 小写字母 a-z 的ascii码的范围是97,122
    // 没一个字母和小写相差32 大写加32即为小写
    public String toLowerCase2(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                str.append((char) (c + 32));
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}
