package 面试经典150题.栈;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
public class L155_最小栈 {

    private Stack<Integer> stack;
    int minimum;

    public L155_最小栈() {
        stack = new Stack<>();
        minimum = Integer.MAX_VALUE;
    }

    public void push(int val) {
        // 只用一个变量存储会遇到, min更新时会更新上一个min值
        // 解决方法是,在新的min值入栈之前, 把旧的min值入栈
        if (val <= minimum) {
            stack.push(minimum);
            minimum = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.pop() == minimum) {
            minimum = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minimum;
    }
}
