package 面试经典150题.栈;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * <p>
 * 注意：
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 * <p>
 * <p>
 * 示例 1：
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * <p>
 * 示例 2：
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * <p>
 * 示例 3：
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class L150_逆波兰表达式求值 {

    public int evalRPN(String[] tokens) {
        if(tokens.length == 1){
            return Integer.valueOf(tokens[0]);
        }

        Set<String> symbol = new HashSet<>();
        symbol.add("+");
        symbol.add("-");
        symbol.add("*");
        symbol.add("/");

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (symbol.contains(s)) {
                int x1 = stack.pop();
                int x2 = stack.pop();
                System.out.print(x1 + " " + x2 + " ");
                result = this.calculate(x2, x1, s);
                System.out.print(result);
                System.out.println();
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return result;
    }

    private int calculate(int x, int y, String symbol){
        switch (symbol){
            case "+" :
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
        }
        return 0;
    }

    public static void main(String[] args) {
        L150_逆波兰表达式求值 test = new L150_逆波兰表达式求值();

        int result1 = test.evalRPN(new String[]{"2","1","+","3","*"});
        System.out.println("result=" + result1);

        int result2 = test.evalRPN(new String[]{"4","13","5","/","+"});
        System.out.println("result=" + result2);

        int result3 = test.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        System.out.println("result=" + result3);
    }
}
