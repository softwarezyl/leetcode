package 题库;

import java.util.ArrayList;
import java.util.List;

/*
你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。

比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：

整数 x - 表示本回合新获得分数 x
"+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
"D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
"C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
请你返回记录中所有得分的总和。
 */
public class L682_棒球比赛 {

    public int calPoints(String[] operations) {
        int sum = 0;
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            String s = operations[i];
            int len = arr.size();
            switch (s) {
                case "C":
                    sum -= arr.get(len - 1);
                    arr.remove(len - 1);
                    break;
                case "D":
                    sum += arr.get(len - 1) * 2;
                    arr.add(arr.get(len - 1) * 2);
                    break;
                case "+":
                    sum += (arr.get(len - 1) + arr.get(len - 2));
                    arr.add(arr.get(len - 1) + arr.get(len - 2));
                    break;
                default:
                    sum += Integer.parseInt(s);
                    arr.add(Integer.valueOf(s));
                    break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        L682_棒球比赛 test = new L682_棒球比赛();
        System.out.println(test.calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
}
