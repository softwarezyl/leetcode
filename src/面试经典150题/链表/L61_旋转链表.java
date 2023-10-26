package 面试经典150题.链表;

import common.ListNode;
import common.ListNodeUtils;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
public class L61_旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode currentNode = head;
        int length = 1;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            length++;
        }
        currentNode.next = head;

        ListNode target = new ListNode(-1);
        for (int i = 1; i < length - k % length; i++) {
            head = head.next;
        }
        target.next = head.next;
        head.next = null;

        return target.next;
    }

    public static void main(String[] args) {
        L61_旋转链表 test = new L61_旋转链表();

        ListNode head = ListNodeUtils.construct(new int[]{1, 2, 3, 4, 5});
        ListNode result = test.rotateRight(head, 2);
        ListNodeUtils.print(result);
    }
}
