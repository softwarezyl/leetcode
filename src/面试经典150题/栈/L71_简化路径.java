package 面试经典150题.栈;

import java.util.Deque;
import java.util.LinkedList;

public class L71_简化路径 {

    /**
     * 当前目录入栈,遇到..弹出栈顶  最后直接输出栈内元素
     */
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String item : path.split("/")) {
            if (item.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!item.isEmpty() && !item.equals(".")) {
                stack.push(item);
            }
        }

        String result = new String();
        for (String s : stack) {
            result = "/" + s + result;
        }
        return result.isEmpty() ? "/" : result;
    }
}
