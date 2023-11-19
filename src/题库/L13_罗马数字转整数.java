package 题库;

import java.util.HashMap;
import java.util.Map;

public class L13_罗马数字转整数 {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int maxNum = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int val = map.get(s.charAt(i));

            if (val >= maxNum) {
                result += val;
                maxNum = result;
            } else {
                result -= val;
            }
        }

        return result;
    }
}
