package 面试经典150题;

import java.util.Objects;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * <p>
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 */

/*
    [0][0]=P  [0][1]   [0][2]    [0][3]=I
    [1][0]=A  [1][1]   [1][2]=L  [1][3]=S
    [2][0]=Y  [2][1]=A [2][2]    [2][3]=H
    [3][0]=P  [3][1]   [3][2]    [3][3]=I
 */

public class L6_N字形变换 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        Character[][] arr = new Character[numRows][s.length()];

        int idx = 0;
        int x = 0, y = 0;
        boolean isDown = true;
        while (idx < s.length()) {
            // x轴逐渐增大, 到numRows为止 后减小到0为止
            // y轴保持不变  x趋势变化时+1
            arr[x][y] = s.charAt(idx);
            if (isDown) {
                x++;
            } else {
                x--;
                y++;
            }

            if (x == 0 || x == numRows - 1) {
                isDown = !isDown;
            }
            idx++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (Objects.isNull(arr[i][j]))
                    continue;
                stringBuilder.append(arr[i][j]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        L6_N字形变换 test = new L6_N字形变换();

        //s = "PAYPALISHIRING", numRows = 3
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        String result1 = test.convert(s1, numRows1);
        System.out.println(result1);

        //s = "PAYPALISHIRING", numRows = 4
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        String result2 = test.convert(s2, numRows2);
        System.out.println(result2);

        //s = "AB", numRows = 1
        String s3 = "AB";
        int numRows3 = 1;
        String result3 = test.convert(s3, numRows3);
        System.out.println(result3);

        //s = "ABCD", numRows = 2
        String s4 = "ABCD";
        int numRows4 = 2;
        String result4 = test.convert(s4, numRows4);
        System.out.println(result4);
    }
}
