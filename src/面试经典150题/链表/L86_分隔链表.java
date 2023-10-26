package 面试经典150题.链表;

import common.ListNode;
import common.ListNodeUtils;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 */
public class L86_分隔链表 {

    // 新建两个链表解决
    public ListNode partition(ListNode head, int x) {
        ListNode leftNode = new ListNode(-1);
        ListNode headOfLeft = leftNode;

        ListNode rightNode = new ListNode(-1);
        ListNode headOfRight = rightNode;

        while (head != null) {
            if (head.val < x) {
                leftNode.next = new ListNode(head.val);
                leftNode = leftNode.next;
            } else {
                rightNode.next = new ListNode(head.val);
                rightNode = rightNode.next;
            }
            head = head.next;
        }
        leftNode.next = headOfRight.next;
        return headOfLeft.next;
    }

    // 通过一个链表解决
    public ListNode partition2(ListNode head, int x) {
        ListNode minNode = new ListNode(-1);
        ListNode headOfMinNode = minNode;

        ListNode current = new ListNode(-1);
        // 需要定义出一个新的头, 原来的头节点可能指向的是小于x的值
        ListNode newHead = current;
        current.next = head;

        while (current.next != null) {
            ListNode nextNode = current.next;
            if (nextNode.val < x) {
                minNode.next = new ListNode(nextNode.val);
                minNode = minNode.next;

                current.next = nextNode.next;
                continue;
            }
            current = current.next;
        }
        minNode.next = newHead.next;
        return headOfMinNode.next;
    }

    public static void main(String[] args) {
        L86_分隔链表 test = new L86_分隔链表();

        ListNode head = ListNodeUtils.construct(new int[]{1, 4, 3, 2, 5, 2});
        ListNode result = test.partition2(head, 3);
        ListNodeUtils.print(result);
    }
}
