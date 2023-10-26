package 题库;

import com.sun.media.jfxmediaimpl.HostUtils;

public class L2698_求一个整数的惩罚数 {

    public int punishmentNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i * i);
            if (dfs(s, 0, 0, i)) {
                result += i * i;
            }
        }
        return result;
    }

    private boolean dfs(String s, int start, int res, int target) {
        if (start == s.length()) {
            return res == target;
        }

        int sum = 0;
        for (int i = start; i < s.length(); i++) {
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum + res > target) {
                break;
            }
            if (dfs(s, i + 1, sum + res, target)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L2698_求一个整数的惩罚数 test = new L2698_求一个整数的惩罚数();

        int res = test.punishmentNumber(37);
        System.out.println(res);
    }
}
