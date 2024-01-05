package 题库;

import common.ListNode;

/*
给你一个链表的头节点 head 。
移除每个右侧有一个更大数值的节点。
返回修改后链表的头节点 head 。

示例 1：
输入：head = [5,2,13,3,8]
输出：[13,8]
解释：需要移除的节点是 5 ，2 和 3 。
- 节点 13 在节点 5 右侧。
- 节点 13 在节点 2 右侧。
- 节点 8 在节点 3 右侧。

示例 2：
输入：head = [1,1,1,1]
输出：[1,1,1,1]
解释：每个节点的值都是 1 ，所以没有需要移除的节点。
 */
public class L2487_从链表中移除节点 {

    public ListNode removeNodes(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode node = removeNodes(head.next);
        if (node.val > head.val) {
            head = node;
        } else {
            head.next = node;
        }
        return head;
    }
}
