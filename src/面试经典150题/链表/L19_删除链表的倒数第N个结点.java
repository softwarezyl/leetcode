package 面试经典150题.链表;

import common.ListNode;
import java.util.Stack;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class L19_删除链表的倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        int len = getLength(head) - n + 1;
        ListNode current = dummy;
        for (int i = 0; i < len; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        return dummy.next;
    }

    private int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    /**
     * 通过栈解决
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        Stack<ListNode> stack = new Stack<>();
        ListNode current = dummy;
        while(current != null){
            stack.push(current);
            current = current.next;
        }

        for(int i=0; i<n; i++){
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;

        return dummy.next;
    }
}
